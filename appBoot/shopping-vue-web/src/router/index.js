import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import login from '@/components/login/login'
import upload from '@/components/upload/upload'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      redirect: '/login'
    },
    {
      path: '/login',
      name: 'login',
      component: login,
      meta:{
        requireAuth:false
      }
    },
    {
      path: '/upload',
      name: 'upload',
      component: upload,
      meta:{
        requireAuth:false
      }
    }
  ]
})
