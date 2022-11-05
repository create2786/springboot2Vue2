<template>
  <div class="login">
    <div
        class="box-shadow-grey"
        style="margin: 200px auto; background-color: white; width: 350px; height: 320px; padding: 20px;">
      <div style="margin: 20px 0; text-align: center;"><h2>登 录</h2></div>
      <el-form ref="userForm" :model="user" :rules="rules">
        <el-form-item prop="username">
          <el-input v-model="user.username" prefix-icon="el-icon-user" size="medium" style="margin: 10px 0"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input v-model="user.password" prefix-icon="el-icon-lock" show-password size="medium"
                    style="margin: 10px 0"></el-input>
        </el-form-item>
        <el-form-item style="margin: 10px 0;">
          <el-button autocomplete="off" size="small" style="margin-left: 50px" type="primary"
                     @click="$router.push('/register')">注册
          </el-button>
          <el-button autocomplete="off" size="small" style="margin-left: 80px" type="primary" @click="login">登录
          </el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "Login",
  data() {
    return {
      user: {},
      rules: {
        username: [
          {required: true, message: '请输入用户名', trigger: 'blur'},
          {min: 3, max: 20, message: '用户名长度在3 ~ 20 个字符之间', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
          {min: 3, max: 20, message: '密码长度在3 ~ 20 个字符之间', trigger: 'blur'}
        ],
      }
    }
  },
  methods: {
    login() {
      //校验elemntui from表单自带
      this.$refs['userForm'].validate((valid) => {
        if (valid) {
          request.post("/user/login", this.user).then(res => {
            if (res.code === '200') {
              //存储到本地浏览器
              localStorage.setItem("user", JSON.stringify(res.data))
              localStorage.setItem("menus", JSON.stringify(res.data.menus))  //存储菜单列表保存在本地
              // console.log(res)
              this.$router.push("/")
              this.$message.success("登录成功")
            } else {
              this.$message.error(res.msg)
            }
          })
        } else {
          this.$message.error("效验失败不合法")
          return false;
        }
      });
    }
  }
}
</script>

<style scoped>
.login {
  height: 100vh;
  overflow: hidden;
  background: url("../assets/img/wallhaven-zme9dg.png") no-repeat;
  background-size: cover;
}
</style>