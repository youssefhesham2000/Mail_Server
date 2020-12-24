import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import router from './router'
import 'material-design-icons-iconfont/dist/material-design-icons.css'
import VueRouter from 'vue-router';
import mainPage from './components/mainPage'

Vue.use(VueRouter);
Vue.config.productionTip = false

const routes={
'/':App,

}

new Vue({
  vuetify,
  router,
data:{
  currentRoute:window.location.pathname
},
computed:{

   currenComponent(){
     return routes[this.currentRoute] || mainPage;
   }

},

  render: function(h){
    return h(this.currenComponent);
  },
  
  // h => h(App)
}).$mount('#app')
