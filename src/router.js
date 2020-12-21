import Vue from 'vue'
import Router from 'vue-router'
import email from './components/email'
import compose from './components/compose'
import EmailModification from './components/EmailModification'
import table from './components/table'
import HelloWorld from './components/HelloWorld'
import Contacts from './components/Contacts'
Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
     {
      path: '/play',
      name: 'email',
      component: email
    },
   {
      path: '/table',
      name: 'table',
      component: table
    },
       {
      path: '/try',
      name: 'HelloWorld',
      component: HelloWorld
    },
        {
      path: '/compose',
      name: 'compose',
      component: compose
    },
    {
      path: '/EmailModification',
      name: 'EmailModification',
      component: EmailModification
    },
    {
      path: '/Contacts',
      name: 'Contacts',
      component: Contacts
    }
  ]
})