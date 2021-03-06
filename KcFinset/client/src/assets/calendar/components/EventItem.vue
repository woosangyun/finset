<template>
    <div ref="event_block" class="v-cal-event-item"
         :title="event.displayText"
         :class="eventClasses"
         @click.stop="eventClicked"
         :style="eventStyles"
         v-if="isShow(event.type)"
         >
        <span class="v-cal-event-name">{{ event.displayText }}</span>
    </div>
</template>

<script>
import moment from "moment";
import { EventBus } from "./EventBus";

export default {
  name: "EventItem",
  props: {
    event: {
      type: Object,
      required: true
    },
    hasDynamicSize: {
      type: Boolean,
      default: true
    }
  },
  data() {
    return {
      ancestorHeight: 0
    };
  },
  mounted() {
    if (this.hasDynamicSize) {
      this.getAndSetAncestorHeight();
      window.addEventListener("resize", this.getAndSetAncestorHeight);
    }
  },
  beforeDestroy() {
    if (this.hasDynamicSize)
      window.removeEventListener("resize", this.getAndSetAncestorHeight);
  },
  methods: {
    eventClicked() {
      EventBus.$emit("event-clicked", this.event);
    },
    getAndSetAncestorHeight() {
      this.ancestorHeight = this.findAncestor(
        this.$refs.event_block,
        "v-cal-day__hour-content"
      ).offsetHeight;
    },
    findAncestor(el, cls) {
      while ((el = el.parentElement) && !el.classList.contains(cls));
      return el;
    },
    isShow(type) {
        switch(type) {
            case "income":
                if(this.$parent.$parent.isActiveIncome){
                    return true;
                } else {
                    return false;
                }
            break;
            case "consume":
                if(this.$parent.$parent.isActiveConsume){
                    return true;
                } else {
                    return false;
                }
            break;
            case "debt":
                if(this.$parent.$parent.isActiveDebt){
                    return true;
                } else {
                    return false;
                }
            break;
        }
    }
  },
  computed: {
    displayHeight() {
      const end =
        this.event.endTime.hours() > 0
          ? moment(this.event.endTime)
          : moment(this.event.endTime).add(1, "days");

      const hours = end.diff(this.event.startTime, "hours", true);
      const bordersOffset = hours - 1;
      return hours * this.ancestorHeight + bordersOffset;
    },
    eventStyles() {
      let styles = [];
      styles.push({
        backgroundColor: this.event.color,
        color: this.event.color
      });

      if (this.hasDynamicSize) {
        styles.push({
          height: this.displayHeight + "px"
        });

        if (this.event.overlaps > 0) {
          const width = 100 / (this.event.overlaps + 1);
          styles.push({
            width: width + "%",
            left: width + "%"
          });
        }

        if (this.event.startTime.minutes() > 0) {
          const distance =
            (this.ancestorHeight / 60) * this.event.startTime.minutes();
          styles.push({
            top: distance + "px"
          });
        }
      }

      return styles;
    },
    eventClasses() {
      return {
        "is-overlapping": this.event.overlaps > 0
      };
    }
  },
};
</script>

<style scoped>
</style>