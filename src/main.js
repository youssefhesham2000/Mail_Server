import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import router from './router'
import 'material-design-icons-iconfont/dist/material-design-icons.css'
import VueRouter from 'vue-router';
import "vuetify/dist/vuetify.min.css";

Vue.use(VueRouter);
Vue.config.productionTip = false
Vue.use(vuetify)
new Vue({
  vuetify,
  router,
  render: h => h(App)
}).$mount('#app')
