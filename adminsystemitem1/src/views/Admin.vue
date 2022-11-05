<template>
  <el-container style="min-height: 100vh;">
    <el-aside :width="asideWd+'px'" style="background-color: rgb(238, 241, 246)">
      <Aside :isCollapse="isCollapse" :textBShow="textBShow"></Aside>
      <!--      父传子属性 props 子传父$emit-->
    </el-aside>

    <el-container>
      <el-header>
        <Header :collapseBthClass="collapseBthClass" @asideCollapse="collapse"></Header>
      </el-header>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import Aside from "@/components/Aside";
import Header from "@/components/Header";
import request from "@/utils/request";

export default {
  components: {
    Header,
    Aside,
  },
  created() {
    this.getUser()
  },

  data() {
    return {
      collapseBthClass: "el-icon-s-fold",
      isCollapse: false,//false展开默认
      asideWd: 200,//侧边宽度
      textBShow: true,//显示后台管理系统
      user: {}
    }
  },
  methods: {
    collapse() {//点击收缩true,false展开
      this.isCollapse = !this.isCollapse
      if (this.isCollapse) {//true收缩
        this.asideWd = 65
        this.collapseBthClass = "el-icon-s-unfold"
        this.textBShow = false
      } else { //false展开
        this.asideWd = 200
        this.collapseBthClass = "el-icon-s-fold"
        this.textBShow = true
      }
    },
    getUser() {
      let username = localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")).username : ""
      if (username) {
        // 从后台获取User数据
        request.get("/user/username/" + username).then(res => {
          // 重新赋值后台的最新User数据
          this.user = res.data
          // console.log(this.user.menus)
        })
      }
    }
  }
}
</script>
<style>
.el-header {
  color: #333;
  line-height: 60px;
  border-bottom: 1px solid #ccc;
}

.el-aside {
  color: #333;
}
</style>