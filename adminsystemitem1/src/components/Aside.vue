<template>
  <!--  //opens默认树型展开列表-->
  <el-menu :collapse="isCollapse" :collapse-transition="false"
           :default-openeds="opens"
           background-color="rgb(245,245,245)"
           router
           style="min-height: 100%; overflow-x: hidden"
  >
    <!--router路由跳转 -->
    <div style="height: 60px;line-height: 60px; text-align: center">
      <img class="mr-5" src="../assets/Cat.jpg" style="width: 20px; position: relative; top: 5px;">
      <b v-show="textBShow">后台管理系统</b>
    </div>
    <div v-for="item in menus" :key="item.id">
      <div v-if="item.menuPath">
        <el-menu-item :index="item.menuPath">
          <!--index="/"重定向直接到home首页-->
          <i :class="item.menuIcon"></i>
          <span slot="title">{{ item.username }}</span>
        </el-menu-item>
      </div>
      <div v-else>
        <!--        获取的id是数字改为字符串-->
        <el-submenu :index="item.id + ''">
          <template slot="title">
            <i :class="item.menuIcon"></i>
            <span slot="title">{{ item.username }}</span>
          </template>
          <div v-for="subItem in item.children" :key="subItem.id">
            <el-menu-item :index="subItem.menuPath">
              <i :class="subItem.menuIcon"></i>
              <span slot="title">{{ subItem.username }}</span>
            </el-menu-item>
          </div>
        </el-submenu>
      </div>
    </div>
  </el-menu>
</template>

<script>
export default {
  name: "Aside",
  props: {//父传子属性
    isCollapse: Boolean,
    textBShow: Boolean,
  },
  data() {
    return {
      menus: localStorage.getItem("menus") ? JSON.parse(localStorage.getItem("menus")) : [],
      //opens默认树型展开列表
      opens: localStorage.getItem("menus") ? JSON.parse(localStorage.getItem("menus")).map(v => v.id + '') : [],

    }
  },
}
</script>

<style scoped>

</style>