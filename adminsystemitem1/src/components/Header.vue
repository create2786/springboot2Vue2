<template>
  <div style="display: flex">
    <div style="flex: 1; font-size: 18px">
      <span :class="collapseBthClass" style="cursor: pointer;" @click="collapse"></span>
      <!--      Breadcrumb 面包屑-->
      <el-breadcrumb class="ml-10" separator="/" style="display: inline-block;">
        <el-breadcrumb-item :to="'/'">首页</el-breadcrumb-item>
        <el-breadcrumb-item>{{ currentPathName }}</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <el-dropdown style="width: 150px;cursor: pointer;text-align: right">
      <div style="display: inline-block">
        <img :src="user.headPortrait" alt=""
             style="width: 30px;border-radius: 50%;position: relative; top: 10px;right: 5px;">
        <span>{{ user.nickname }}</span>
        <i class="el-icon-arrow-down ml-5"></i>
      </div>
      <el-dropdown-menu slot="dropdown" style="width: 120px;text-align: center">
        <el-dropdown-item>
          <router-link style="text-decoration: none;" to="/personal">个人信息</router-link>
        </el-dropdown-item>
        <el-dropdown-item>
          <div class="td" @click="logout">注销</div>
        </el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  </div>
</template>

<script>
import store from "../store"

export default {
  name: "Header",
  props: {
    collapseBthClass: String,
  },
  data() {
    return {
      //获取登录后的对象,登录后信息被存储在本地浏览器
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
    }
  },
  computed: {//computed有缓存不用一直执行
    currentPathName() {
      return store.state.currentPathName; //监听数据路由名
    }
  },
  methods: {
    collapse() {//$emit子传父方法
      this.$emit("asideCollapse")
    },
    //退出注销登录
    logout() {
      this.$router.push("/login")
      localStorage.removeItem("user")
      this.$message.success("注销成功")
    }
  }
}
</script>

<style scoped>

</style>