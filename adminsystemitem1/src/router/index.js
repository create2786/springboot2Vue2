import Vue from 'vue'
import VueRouter from 'vue-router'
import store from "@/store";

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'admin',
        redirect: 'home',//redirect重定向到首页
        component: () => import('../views/Admin.vue'),
        children: [
            {
                path: '/home',
                name: 'home',
                meta: {title: '主页'},
                component: () => import('../views/Home.vue')
            },
            {
                path: '/user',
                name: 'user',
                meta: {title: '用户列表'},
                component: () => import('../views/User.vue'),
            },
            {
                path: "/personal",
                name: 'personal',
                meta: {title: '个人信息'},
                component: () => import('../views/Personal')
            },
            {
                path: '/goods',
                name: 'goods',
                meta: {title: '商品列表'},
                component: () => import('../views/Goods')
            },
            {
                path: '/role',
                name: 'role',
                meta: {title: '角色管理'},
                component: () => import('../views/Role')
            },
            {
                path: '/menu',
                name: 'menu',
                meta: {title: '菜单管理'},
                component: () => import('../views/Menu')
            }
        ]
    },
    {
        path: '/login',
        name: 'login',
        component: () => import('../views/Login.vue')
    },
    {
        path: '/register',
        name: 'register',
        component: () => import('../views/Register.vue')
    },
    //前台首页
    {
        path: '/frontHome',
        name: 'frontHome',
        component: () => import('../front/FrontHome')
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

//全局前置守卫
/*
to: Route: 即将要进入的目标 路由对象
from: Route: 当前导航正要离开的路由
next(): 进行管道中的下一个钩子。如果全部钩子执行完了，则导航的状态就是 confirmed (确认的)
 */
router.beforeEach((to, from, next) => {
    localStorage.setItem('currentPathName', to.meta.title) //将路由名保存到本地存储实现Header Breadcrumb 面包屑
    store.commit("setPath") //触发store的数据更新
    next()
})

export default router
