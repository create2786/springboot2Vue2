import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'
import './assets/public.css'
// 引入 echarts
import * as echarts from 'echarts';
import request from "@/utils/request";
//引入vuex
//将 echarts 挂载到vue的原型上
Vue.prototype.$echarts = echarts
Vue.config.productionTip = false
Vue.prototype.require = request//导入axios
new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
