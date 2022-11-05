<template>
  <div>
    <div class="pd-10">
      <el-input v-model="username" placeholder="请输入名称" size="mini" style="width: 200px"
                suffix-icon="el-icon-search"></el-input>
      <el-input v-model="email" class="ml-5" placeholder="请输入邮箱" size="mini" style="width: 200px"
                suffix-icon="el-icon-message"></el-input>
      <el-input v-model="address" class="ml-5" placeholder="请输入地址" size="mini"
                style="width: 200px" suffix-icon="el-icon-position"></el-input>
      <el-button class="ml-5" round size="mini" type="primary" @click="loadData">搜索</el-button>
      <el-button class="ml-5" round size="mini" type="danger" @click="reset">重置搜索</el-button>
    </div>
    <div class="pd-10">
      <el-button round size="mini" type="primary" @click="adminAdd">增加<i class="el-icon-circle-plus-outline"></i>
      </el-button>
      <el-popconfirm
          cancel-button-text='不用了'
          class="ml-5"
          confirm-button-text='确定'
          icon="el-icon-info"
          icon-color="red"
          title="你确定要批量删除这些内容吗？"
          @confirm="deleteBatch()"
      >
        <el-button slot="reference" round size="mini" type="danger">批量删除<i class="el-icon-remove-outline"></i>
        </el-button>
      </el-popconfirm>

    </div>
    <el-table :data="tableData" border header-row-class-name="headerBg" stripe
              @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column label="id" prop="id" sortable width="70"></el-table-column>
      <el-table-column label="用户名" prop="username"></el-table-column>
      <el-table-column label="角色" prop="role"></el-table-column>
      <el-table-column label="昵称" prop="nickname"></el-table-column>
      <el-table-column label="邮箱" prop="email"></el-table-column>
      <el-table-column align="center" label="操作" width="200">
        <template slot-scope="scope">
          <el-button
              size="mini"
              @click="handleEdit(scope.row)">编辑
          </el-button>
          <el-popconfirm
              cancel-button-text='不用了'
              class="ml-5"
              confirm-button-text='好的'
              icon="el-icon-info"
              icon-color="red"
              title="这是一段内容确定删除吗？"
              @confirm="handleDelete(scope.row.id)"
          >
            <el-button
                slot="reference"
                size="mini" type="danger">删除
            </el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div class="pd-10" style="display: flex">
      <el-pagination
          :current-page="pageNum"
          :page-size="pageSize"
          :page-sizes="[5, 7, 15, 20]"
          :total="total"
          layout="total, sizes, prev, pager, next, jumper"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      >
      </el-pagination>
      <div class="ml-10">
        <el-upload
            :on-success="excelImportSuccess"
            :show-file-list="false"
            accept="xlsx"
            action="http://localhost:606/user/import"
            class="mr-5"
            style="display: inline-block"
        >
          <el-button round size="mini" type="primary">导入<i class="el-icon-bottom"></i></el-button>
        </el-upload>
        <el-button round size="mini" type="primary" @click="excelExport">导出<i class="el-icon-top"></i></el-button>
      </div>
    </div>
    <el-dialog :visible.sync="dialogFormVisible" title="用户信息" width="33.3%">
      <el-form label-width="100px">
        <el-form-item label="用户名">
          <el-input v-model="form.username" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="角色">
          <el-select v-model="form.role" clearable placeholder="请选择角色" style="width: 100%">
            <el-option v-for="item in roles" :key="item.username" :label="item.username"
                       :value="item.roleKey"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="昵称">
          <el-input v-model="form.nickname" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="邮箱">
          <el-input v-model="form.email" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="地址">
          <el-input v-model="form.address" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveData">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "User",
  data() {
    return {
      headerBg: 'headerBg',
      tableData: [],
      total: 0,//分页数量
      pageNum: 1,//默认显示第一页
      pageSize: 7,//默认显示7条数据
      username: "",//搜索用户名
      email: "",//搜索邮箱
      address: "",//搜索地址
      nickname: "",//昵称
      dialogFormVisible: false,//增删改查编辑信息,false默认不展示,true展示
      form: {},//编辑表内容
      multipleSelection: [],//批量删除的数据
      roles: [],//角色数组
    }
  },
  //分页查询数据
  created() {
    this.loadData()
  },
  methods: {
    loadData() {//api请求
      //转为json对象res.json
      request.get("/user/page", {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          username: this.username,
          email: this.email,
          address: this.address,
        }
      }).then(res => {
        console.log(res, "data内容请求user")
        this.tableData = res.data.records;//内容数据
        this.total = res.data.total; //分页总页数
      })
      request.get("/role").then(res => {
        this.roles = res.data;
      })
    },
    //分页改变
    handleSizeChange(pageSize) {
      console.log(`每页 ${pageSize} 条`);
      this.pageSize = pageSize
      this.loadData()
    },
    handleCurrentChange(pageNum) {
      console.log(`当前页: ${pageNum}`);
      this.pageNum = pageNum
      this.loadData()
    },
    //搜索重置
    reset() {
      this.username = ""
      this.email = ""
      this.address = ""
    },
    //新增
    adminAdd() {
      this.dialogFormVisible = true;

    },
    //保存数据
    saveData() {
      request.post("/user", this.form).then(res => {
        if (res) {
          this.$message.success("保存数据成功")
          this.dialogFormVisible = false;
          this.loadData()
        } else {
          this.$message.error("保存数据失败,请联系管理员查看后台")
        }
      })
    },
    //编辑
    handleEdit(row) {
      // console.log(row)
      this.form = row;
      this.dialogFormVisible = true;
    },
    //删除
    handleDelete(id) {
      request.delete(`/user/${id}`).then(res => {
        if (res) {
          this.$message.success("删除成功")
          this.loadData();
        } else {
          this.$message.error("删除失败")
        }
      })
    },
    //批量删除收集的数据
    handleSelectionChange(val) {
      console.log(val);
      this.multipleSelection = val;
    },
    //批量删除操作
    deleteBatch() {
      let ids = this.multipleSelection.map(i => i.id) //将对象转为数组形式如:[{},{}] => [a,b,c]
      request.post("/user/del/batch", ids).then(res => {
        if (res) {
          this.$message.success("批量删除成功")
          this.loadData()
        } else {
          this.$message.error("批量删除失败")
        }
      })
    },
    //导出
    excelExport() {
      window.open("http://localhost:606/user/export")
    },
    //导入成功提示钩子函数
    excelImportSuccess() {
      this.$message.success("导入成功")
      this.loadData()
    }
  }
}
</script>

<style scoped>
.headerBg {
  background-color: red !important;
}
</style>