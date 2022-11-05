<template>
  <div class="personal box-shadow-grey">
    <el-form label-width="100px">
      <el-form-item style="margin-left: 110px">
        <img :src="form.headPortrait" style="width: 80px">
      </el-form-item>
      <el-form-item label="用户名">
        <el-input v-model="form.username" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="头像链接">
        <el-input v-model="form.headPortrait" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="form.password" autocomplete="off" type="password"></el-input>
      </el-form-item>
      <el-form-item label="昵称">
        <el-input v-model="form.nickname" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="手机号">
        <el-input v-model="form.phone" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="form.email" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="地址">
        <el-input v-model="form.address" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="saveData">保 存 修 改</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "Personal",
  data() {
    return {
      form: {},
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
    }
  },
  created() {
    request.get("/user/username/" + this.user.username).then(res => {
      if (res.code === '200') {
        this.form = res.data
      }
    })
  },
  methods: {
    //保存数据
    saveData() {
      request.post("/user", this.form).then(res => {
        if (res) {
          this.$message.success("保存数据成功")
        } else {
          this.$message.error("保存数据失败,请联系管理员查看后台")
        }
      })
    },
    handleAvatarSuccess(res) {
      console.log(res, "url")
      this.form.avatarUrl = res;
    }
  }
}
</script>

<style scoped>

.personal {
  width: 600px;
  margin: 50px auto;
  padding: 60px;
}
</style>