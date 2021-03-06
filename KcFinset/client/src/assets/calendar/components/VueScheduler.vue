<template>
  <div class="v-cal">
    <header class="v-cal-header">
      <div class="v-cal-header__actions">
        <div class="actions-left">
          <div @click="changeType">
            <h3 class="v-cal-header__title font-mon">{{ calendarMonth }}</h3>
            <h3 class="v-cal-header__title font-year">{{ calendarYear }}</h3>
          </div>
          <button class="v-cal-button today-button" @click="goToToday" :class="{ 'v-cal-button--is-active': activeDate && activeDate.isSame( today, 'day' )}">{{ labels.today }}</button>
				</div>
        <div class="actions-right">
          <button class="v-cal-button income-button" :class="{ active:isActiveIncome }" @click="clickIncome">수입</button>
          <button class="v-cal-button consume-button" :class="{ active:isActiveConsume }" @click="clickConsume">지출</button>
          <button class="v-cal-button debt-button" :class="{ active:isActiveDebt }" @click="clickDebt">대출</button>
        </div>
      </div>
    </header>
    <component
      :is="activeView"
      :class="'v-cal-content--' + activeView"
      v-bind="activeViewProps"
    ></component>
    <footer class="v-cal-footer"></footer>
  </div>
</template>

<script>
import Event from "../model/Event";

import config from "../utils/config";
import { defaultLabels, defaultViews } from "../utils/config";

import { EventBus } from "./EventBus";

import moment from "moment";
import Month from "./views/Month";

export default {
  name: "VueScheduler",
  components: { Month },
  props: {
    events: {
      type: Array,
      default: () => []
    },
    labels: {
      type: Object,
      default: () => config.labels,
      validator(value) {
        for (const labelKey in defaultLabels) {
          if (!value.hasOwnProperty(labelKey)) {
            console.error("Missing prop label: " + labelKey);
            return false;
          }
        }
        return true;
      }
    },
    initialDate: {
      type: [Date, Object],
      default: () => config.initialDate
    },
    initialView: {
      type: String,
      default: () => config.initialView
    },
    eventDisplay: {
      type: [String, Function],
      default: () => config.eventDisplay
    }
  },
  data() {
    return {
      today: moment(),
      activeView: "",
      activeDate: null,
      isActiveIncome: true,
      isActiveConsume: true,
      isActiveDebt: true
    };
  },
  mounted() {
    moment.locale("ko");
    //  Initial setup
    this.activeView = this.initialView;
    this.activeDate = moment(this.initialDate).locale("ko");

    //화면 이동 로직
    var _this = this;
    let origMousePoint;
    $(document).on("mousedown", ".v-cal-content", function(event) {
      origMousePoint = event.clientX;
    });
    $(document).on("mouseup", ".v-cal-content", function(event) {
      if (origMousePoint - event.clientX > 150) {
        _this.next();
      } else if (origMousePoint - event.clientX < -150) {
        _this.prev();
      }
    });
    $(document).on("touchstart", ".v-cal-content", function(event) {
      origMousePoint = event.touches[0].clientX;
    });
    $(document).on("touchend", ".v-cal-content", function(event) {
      if (origMousePoint - event.changedTouches[0].clientX > 150) {
        _this.next();
      } else if (origMousePoint - event.changedTouches[0].clientX < -150) {
        _this.prev();
      }
    });
    ////화면 이동 로직

    //  Bind events
    this.bindEvents();
  },
  beforeDestroy() {
    EventBus.$off("day-clicked");
    EventBus.$off("time-clicked");
    EventBus.$off("event-clicked");
  },
  methods: {
    bindEvents() {
      var _this = this;
      EventBus.$on("event-clicked", event => {
        this.$emit("event-clicked", {
          date: event.date.toDate(),
          isActiveIncome: _this.isActiveIncome,
          isActiveConsume: _this.isActiveConsume,
          isActiveDebt: _this.isActiveDebt
        });
      });
    },
    goToToday() {
      this.activeDate = moment(this.today).locale("ko");
    },
    prev(e) {
      this.activeDate = moment(
        this.activeDate.subtract(1, this.activeView + "s")
      );
      this.$emit("curYM", this.activeDate.format("YYYYMM"));
    },
    next(e) {
      this.activeDate = moment(this.activeDate.add(1, this.activeView + "s"));
      this.$emit("curYM", this.activeDate.format("YYYYMM"));
    },
    clickIncome(e) {
      this.clickBtn(e);
      this.isActiveIncome = !this.isActiveIncome;
    },
    clickConsume(e) {
      this.clickBtn(e);
      this.isActiveConsume = !this.isActiveConsume;
    },
    clickDebt(e) {
      this.clickBtn(e);
      this.isActiveDebt = !this.isActiveDebt;
    },
    clickBtn(e) {
      var isActive = e.toElement.classList.contains("active");
      if (isActive) {
        e.toElement.classList.remove("active");
      } else {
        e.toElement.classList.add("active");
      }
    },
    changeType() {
      console.log('cahnge')
    }
  },
  filters: {
  },
  watch: {
    initialDate() {
      this.activeDate = moment(this.initialDate);
    },
    initialView() {
      this.activeView = this.initialView;
    },
    activeDate() {
      this.$emit(this.activeView + "-changed", this.activeDate.toDate());
    },
    activeView() {
      this.$emit("view-changed", this.activeView);
    }
  },
  computed: {
    newEvents() {
      return this.events.map(e => {
        return new Event(e).bindGetter("displayText", this.eventDisplay);
      });
    },
    activeViewProps() {
      let props = {
        activeDate: this.activeDate,
        minDate: this.minDate,
        maxDate: this.maxDate,
        events: this.newEvents.filter(event => {
          return event.date.isSame(this.activeDate, this.activeView);
        })
      };
      return props;
    },
    calendarYear() {
      if (this.activeDate === null) return "";

      if (this.activeView === "month") {
        return this.activeDate.format("YYYY년");
      }
    },
    calendarMonth() {
      if (this.activeDate === null) return "";

      if (this.activeView === "month") {
        return this.activeDate.format("MMMM");
      }
    },
    getPrevMoment() {
      return moment(moment(this.initialDate).subtract(1, "month" + "s"));
    },
    getNextMoment() {
      return moment(moment(this.initialDate).add(1, "month" + "s"));
    }
  }
};
</script>

<style scoped>
.font-mon {
  font-size: 21px;
  color: #0000ff;
  font-weight: 600;
}
.font-year {
  font-size: 14px;
}
.today-button {
  border: none;
  box-shadow: none;
}
.income-button.active {
  background-color: #3b86ff;
  color: #fff;
}
.consume-button.active {
  background-color: #47d147;
  color: #fff;
}
.debt-button.active {
  background-color: #ff3333;
  color: #fff;
}
</style>
