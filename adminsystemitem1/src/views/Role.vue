<template>
  <div>
    <div class="pd-10">
      <el-input v-model="username" placeholder="请输入角色名称" size="mini" style="width: 200px"
                suffix-icon="el-icon-search"></el-input>
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
      <el-table-column label="角色名称" prop=username></el-table-column>
      <el-table-column label="描述" prop="roleDescribe"></el-table-column>
      <el-table-column align="center" label="操作">
        <template slot-scope="scope">
          <el-button size="mini" type="primary" @click="selectMenu(scope.row)">
            菜单分配
            <i class="el-icon-menu"></i>
          </el-button>
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
    </div>
    <el-dialog :visible.sync="dialogFormVisible" title="角色信息" width="33.3%">
      <el-form label-width="100px">
        <el-form-item label="用户名">
          <el-input v-model="form.username" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="描述">
          <el-input v-model="form.roleDescribe" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveData">确 定</el-button>
      </div>
    </el-dialog>
    <el-dialog :visible.sync="menuDialogVis" title="菜单分配" width="33.3%">
      <el-tree
          ref="tree"
          :data="menuData"
          :default-checked-keys="checks"
          :default-expanded-keys="expends"
          :props="props"
          node-key="id"
          show-checkbox
      >
        <span slot-scope="{ node, data }" class="custom-tree-node">
          <span><i :class="data.menuIcon"></i>  {{ data.username }}</span>
        </span>
      </el-tree>

      <div slot="footer" class="dialog-footer">
        <el-button @click="menuDialogVis = false">取 消</el-button>
        <el-button type="primary" @click="saveRoleMenu">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "Role",
  data() {
    return {
      headerBg: 'headerBg',
      tableData: [],
      total: 0,//分页数量
      pageNum: 1,//默认显示第一页
      pageSize: 7,//默认显示7条数据
      username: "",//搜索用户名
      dialogFormVisible: false,//增删改查编辑信息,false默认不展示,true展示
      form: {},//编辑表内容
      multipleSelection: [],//批量删除的数据
      menuDialogVis: false,//菜单编辑
      menuData: [],
      props: {
        label: 'username'
      },//显示数据在树
      //显示展开树
      expends: [],
      checks: [],
      roleId: 0,
      roleKey: '',//角色唯一标识
      ids: []  //获取管理员/用户菜单ids
    }
  },
  //分页查询数据
  created() {
    this.loadData()
  },
  methods: {
    loadData() {//api请求
      //转为json对象res.json
      request.get("/role/page", {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          username: this.username,
        }
      }).then(res => {
        console.log(res, "data内容请求role")
        this.tableData = res.data.records;//内容数据
        this.total = res.data.total; //分页总页数
      })
      request.get("/menu/ids").then(r => {
        this.ids = r.data
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
    },
    //新增
    adminAdd() {
      this.dialogFormVisible = true;
      this.form = {}
    },
    //保存数据
    saveData() {
      request.post("/role", this.form).then(res => {
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
      request.delete(`/role/${id}`).then(res => {
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
      request.post("/role/del/batch", ids).then(res => {
        if (res) {
          this.$message.success("批量删除成功")
          this.loadData()
        } else {
          this.$message.error("批量删除失败")
        }
      })
    },
    //菜单分配
    async selectMenu(role) {
      this.roleId = role.id
      this.roleKey = role.roleKey

      // 请求菜单数据
      request.get("/menu").then(res => {
        this.menuData = res.data

        // 把后台返回的菜单数据处理成 id数组
        this.expends = this.menuData.map(v => v.id)
      })
      //使数据菜单中管理员选中的子菜单选中展示
      request.get("/role/roleMenu/" + this.roleId).then(res => {
        this.checks = res.data
        this.ids.forEach(id => {
          if (!this.checks.includes(id)) {
            this.$nextTick(() => {
              this.$refs.tree.setChecked(id, false)
            })
          }
        })
        this.menuDialogVis = true
      })
    },
    //角色菜单关联
    saveRoleMenu() {
      request.post("/role/roleMenu/" + this.roleId, this.$refs.tree.getCheckedKeys()).then(res => {
        if (res.code === '200') {
          // this.$message.success("绑定成功")
          this.menuDialogVis = false

          // 操作管理员角色子菜单后需要重新登录
          if (this.roleKey === 'LYW_ADMIN') {
            this.$router.push("/login")
            this.$message.success("更新完管理员请重新登陆");
          }

        } else {
          this.$message.error(res.msg)
        }
      })
    },
  }
}
</script>

<style scoped>
.headerBg {
  background-color: red !important;
}
</style>