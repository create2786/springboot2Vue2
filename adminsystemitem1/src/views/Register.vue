<template>
  <div class="register">
    <div class="box-shadow-grey"
         style="margin: 100px auto; background-color: white; width: 350px; height: 400px; padding: 20px">
      <div style="margin: 20px 0; text-align: center;"><h2>注 册</h2></div>
      <el-form ref="userForm" :model="user" :rules="rules">
        <el-form-item prop="username">
          <el-input v-model="user.username" placeholder="请输入账号" prefix-icon="el-icon-user" size="medium"
                    style="margin: 5px 0"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input v-model="user.password" placeholder="请输入密码" prefix-icon="el-icon-lock" show-password size="medium"
                    style="margin: 5px 0"></el-input>
        </el-form-item>
        <el-form-item prop="confirmPassword">
          <el-input v-model="user.confirmPassword" placeholder="请确认密码" prefix-icon="el-icon-lock" show-password
                    size="medium"
                    style="margin: 5px 0"></el-input>
        </el-form-item>
        <el-form-item style="margin: 5px 0;">
          <el-button autocomplete="off" size="small" style="margin-left: 50px" type="primary" @click="register">注册
          </el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "Register",
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

        confirmPassword: [
          {required: true, message: '请输入确认密码', trigger: 'blur'},
          {min: 3, max: 20, message: '确认密码长度在3 ~ 20 个字符之间', trigger: 'blur'}
        ],
      },
    }
  },
  methods: {
    register() {
      //校验elemntui from表单自带
      this.$refs['userForm'].validate((valid) => {
        if (valid) {
          if (this.user.password != this.user.confirmPassword) {
            this.$message.error("密码不一致")
            return false
          }
          request.post("/user/register", this.user).then(res => {
            if (res.code === '200') {
              this.$router.push("/login")
              this.$message.success("注册成功")
            } else {
              this.$router.push("/register")
              this.$message.error("注册失败")
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
.register {
  height: 100vh;
  overflow: hidden;
  background: url("../assets/img/wallhaven-zme9dg.png") no-repeat;
  background-size: cover;
}
</style>