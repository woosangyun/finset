<template>
  <div id="wrapper">
    <!-- Content -->
    <section id="content">
      
      <div class="sub-top">
          <a href="#" class="btn-back"></a>
          <p class="title">약관동의</p>
      </div>

      <div class="container mt30">
        <div class="checks">
          <!-- <div v-bind:class="checked"> -->
            <!--전체약관동의-->
            <input type="checkbox" id="check-all" v-model="chkAll" v-on:click="allChecked()"><label for="check-all">전체 약관 동의</label>
            
            <div class="box-agree">
              <p><input type="checkbox" name="checkbox1" id="checkbox1" v-model="chkBox1"><label for="checkbox1">[필수] 서비스 이용동의</label></p>
              <ul>
                <li><a v-on:click="open('1')">서비스 이용약관</a>
                  <vue-modal transitionName="zoom-in" width="100%" name="my-modal1">
                    <Terms1 slot="header"></Terms1>
                  </vue-modal>
                </li>
                <li><a v-on:click="open('2')">개인정보 처리방침</a>
                  <vue-modal transitionName="zoom-in" name="my-modal2">
                    <Terms2 slot="header"></Terms2>
                  </vue-modal>
                </li>
                <li><a v-on:click="open('3')">KCB 올크레딧 이용약관</a>
                  <vue-modal transitionName="zoom-in" name="my-modal3">
                    <Terms3 slot="header"></Terms3>
                  </vue-modal>
                </li>
                <li><a v-on:click="open('4')">개인정보 수집·이용 동의</a>
                  <vue-modal transitionName="zoom-in" name="my-modal4">
                    <Terms4 slot="header"></Terms4>
                  </vue-modal>
                </li>
                <li><a v-on:click="open('5')">개인정보 제3자 제공 동의</a>
                  <vue-modal transitionName="zoom-in" name="my-modal5">
                    <Terms5 slot="header"></Terms5>
                  </vue-modal>
                </li>
              </ul>
            </div>

            <div class="box-agree">
              <p><input type="checkbox" name="checkbox2" id="checkbox2" v-model="chkBox2"><label for="checkbox2">[필수] 통신사/본인확인 서비스 이용 동의</label></p>
              <ul>
                <li><a v-on:click="open('6')">본인확인서비스 이용약관</a>
                  <vue-modal transitionName="zoom-in" name="my-modal6">
                    <Terms6 slot="header"></Terms6>
                  </vue-modal>
                </li>
                <li><a v-on:click="open('7')">개인정보 수집 · 이용/취급위탁 동의</a>
                  <vue-modal transitionName="zoom-in" name="my-modal7">
                    <Terms7 slot="header"></Terms7>
                  </vue-modal>
                </li>
                <li><a v-on:click="open('8')">고유식별정보처리 동의</a>
                  <vue-modal transitionName="zoom-in" name="my-modal8">
                    <Terms8 slot="header"></Terms8>
                  </vue-modal>
                </li>
                <li><a v-on:click="open('9')">통신사 본인확인 이용약관 동의</a>
                  <vue-modal transitionName="zoom-in" name="my-modal9">
                    <Terms9 slot="header"></Terms9>
                  </vue-modal>
                </li>
              </ul>
            </div>
            

            <div class="box-agree">
              <p><input type="checkbox" name="checkbox3" id="checkbox3" v-model="chkBox3"><label for="checkbox3">[선택] 마케팅 정보 수신 동의</label></p>
              <ul>
                <li><a v-on:click="open('10')">마케팅 정보 수신 동의</a>
                  <vue-modal transitionName="zoom-in" name="my-modal5">
                    <Terms10 slot="header"></Terms10>
                  </vue-modal>
                </li>
              </ul>
            </div>
        </div>
      </div>
      <!-- next button -->
      <div class="btn-wrap">
        <a role="button" id="confirmButton" class="btn-next" v-on:click="confirmedTerms()">다음</a>
      </div>
    </section>
  </div>
  
  
</template>

<script>
import Common from "./../../assets/js/common.js";
import Constant from "./../../assets/js/constant.js";
import Terms1 from "./Terms1.vue";
import Terms2 from "./Terms2.vue";
import Terms3 from "./Terms3.vue";
import Terms4 from "./Terms4.vue";
import Terms5 from "./Terms5.vue";
import Terms6 from "./Terms6.vue";
import Terms7 from "./Terms7.vue";
import Terms8 from "./Terms8.vue";
import Terms9 from "./Terms9.vue";
import Terms10 from "./Terms10.vue";

export default {
  name: "certStep1",
  data() {
    return {
      errMsg: "",
      checked: "",
      chkAll: false,
      chkBox1: false,
      chkBox2: false,
      chkBox3: false
    };
  },
  components: {
    Terms1: Terms1,
    Terms2: Terms2,
    Terms3: Terms3,
    Terms4: Terms4,
    Terms5: Terms5,
    Terms6: Terms6,
    Terms7: Terms7,
    Terms8: Terms8,
    Terms9: Terms9,
    Terms10: Terms10
  },
  beforeCreate() {},
  created() {
    if (Constant.userAgent == "Android") {
      window.Android.setEndApp("Y");
    }
    this.$store.state.title = "약관동의 (1/7)";
  },
  beforeMount() {},
  mounted() {
    var _this = this;

    $(":checkbox").change(function() {
      Common.affixBottom("hide");
      //약관 전체동의 체크
      if (_this.chkBox1 && _this.chkBox2 && _this.chkBox3) {
        _this.chkAll = true;
        _this.checked = "check";
      } else {
        _this.chkAll = false;
        _this.checked = "";
      }

      if (_this.chkBox1 && _this.chkBox2) {
        Common.affixBottom("show");
      }

      //마케팅 동의수신 체크시 parameter값 셋팅
      if (_this.chkBox3) {
        _this.$store.state.user.isEventPush = true;
      }
    });
  },
  beforeUpdate() {},
  updated() {},
  beforeDestroy() {},
  destroyed() {},
  methods: {
    allChecked: function() {
      var _this = this;
      if (_this.chkAll) {
        _this.chkAll = false;
      } else {
        _this.chkAll = true;
      }

      if (_this.chkAll) {
        _this.checked = "check";
        _this.chkBox1 = true;
        _this.chkBox2 = true;
        _this.chkBox3 = true;
      } else {
        _this.checked = "";
        _this.chkBox1 = false;
        _this.chkBox2 = false;
        _this.chkBox3 = false;
      }
    },

    confirmedTerms: function() {
      var _this = this;
      if (_this.chkBox1 && _this.chkBox2) {
        _this.$router.push("/member/certStep2");
      }
    },

    open: function(gubun) {
      var _this = this;
      _this.$modals.show("my-modal" + gubun);
    }
  }
};
</script>