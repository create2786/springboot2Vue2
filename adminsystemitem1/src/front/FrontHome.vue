<template>
  <div class="about">
    <el-container>
      <el-header>
        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
          <el-menu-item index="1" style="font-size: 18px;margin-left: 80px;color:orangered;">
            <i class="el-icon-shopping-cart-1" style="font-size:30px;color:orangered;"></i> 606商城
          </el-menu-item>
          <el-menu-item index="2" style="width:800px;margin-left: 30px;">
            <template slot="title">
              <el-input v-model="input3" class="input-with-select" placeholder="请输入内容">
                <el-button slot="append" icon="el-icon-search"></el-button>
              </el-input>
            </template>
          </el-menu-item>
          <el-menu-item index="3" style="font-size:18px;color:orangered;margin-right: 10px;">
            <el-col :span="8">
              <i class="el-icon-chat-dot-square" style="font-size:20px;padding-right: 17px;margin-left: -10px;">
                <span class="no1"> 消息</span></i>
            </el-col>
          </el-menu-item>
          <el-menu-item index="4" style="font-size:18px;color:orangered;margin-bottom: 10px;margin-right: 10px">
            <el-col :span="8"><span class="grid-content">
        <i class="el-icon-star-off" style="font-size:18px;padding-right: 20px;margin-left: -10px;">
          <span class="no1"> 收藏</span></i>
      </span></el-col>
          </el-menu-item>
          <el-menu-item index="5" style="color:orangered">
            <el-col :span="8"><span class="grid-content">
        <i class="el-icon-shopping-cart-2" style="font-size:18px;padding-right: 35px;margin-left: -7px;">
          <span class="no1"> 购物车</span></i>
      </span></el-col>
          </el-menu-item>
          <el-menu-item index="6" style="margin-left:30px">
            <el-tooltip class="item" content="用户:蔡徐坤" effect="dark" placement="right">
      <span class="grid-content">
        <img class="me" src="../assets/frontimg/个人主页.png">
      </span>
            </el-tooltip>
          </el-menu-item>
        </el-menu>
      </el-header>
      <el-main>
        <div class="dv2">
          <el-row>
            <el-col :span="5">
              <div class="grid-content bg-purple">
                <div class="le">
                  <img alt="" src="../assets/frontimg/左上.png">
                  <el-button round style="position: absolute;bottom: 55px;left: 100px;" type="danger">进入主会场</el-button>
                </div>
                <div class="le">
                  <img alt="" src="../assets/frontimg/左1.png">
                  <el-button round style="position: absolute;bottom: 55px;left: 100px;">进入直播间</el-button>
                </div>
              </div>
            </el-col>
            <el-col :span="13">
              <div class="grid-content bg-purple-light">
                <div class="block">
                  <el-carousel height="460px" style="border-radius:10px">
                    <el-carousel-item v-for="item in 4" :key="item">
                      <h3 class="small">{{ item }}</h3>
                    </el-carousel-item>
                  </el-carousel>
                  <el-row class="buy">
                    <el-col :span="11">
                      <div class="grid-content bg-purple"
                           style="background-color:pink;height: 100px;margin-left: 15px; border-radius: 10px;">
                        <el-row>
                          <el-col :span="12">
                            <div class="grid-content bg-purple"
                                 style="font-size:20px;font-family: '黑体';color: white;margin-top: 24px;">
                              必买清单<br><span style="font-size:15px">拯救选择恐惧</span>
                            </div>
                          </el-col>
                          <el-col :span="12">
                            <div class="grid-content bg-purple-light" style="margin-top:10px">
                              <img alt="" src="../assets/frontimg/白.png"
                                   style="width:52%;height:75px ;">
                            </div>
                          </el-col>
                        </el-row>
                      </div>
                    </el-col>
                    <el-col :span="12">
                      <div class="grid-content bg-purple"
                           style="background-color:skyblue;height: 100px;margin-left: 40px;border-radius: 10px;width: 380px;">
                        <el-row>
                          <el-col :span="12">
                            <div class="grid-content bg-purple"
                                 style="font-size:20px;font-family: '黑体';color: white;margin-top: 24px;">
                              抢大额卷<br><span style="font-size:15px">减轻消费焦虑</span>
                            </div>
                          </el-col>
                          <el-col :span="12">
                            <div class="grid-content bg-purple-light" style="margin-top:10px">
                              <img alt="" src="../assets/frontimg/粉.png"
                                   style="width:45%;height:75px ;">
                            </div>
                          </el-col>
                        </el-row>
                      </div>
                    </el-col>
                  </el-row>
                </div>
              </div>
            </el-col>
            <el-col :span="6">
              <div class="grid-content bg-purple">
                <div class="you">
                  <div
                      style="padding: 20px;text-align: center; border-radius: 10px;border: 1px solid #ccc;box-shadow: 0px 0px 15px 5PX #ccc;">
                    <br><span style="font-size:22px;margin-bottom: 10px;">
        <span style="font-size:24px;color: orange;font-family: '楷体';font-weight: bolder;">11.11</span>
          购物商城</span><br>
                    <span style="font-family:'楷体';color:#909399">好物提前种草</span>
                    <div style="width:80%;margin-left: 35px;">
                      <hr>
                    </div>
                    <el-row style="height:80px;margin-top: 5px;">
                      <el-col :span="8">
                        <div class="grid-content bg-purple">
                          <img alt="" src="../assets/frontimg/上衣.png"
                               style="width: 80%;height: 100%;">
                        </div>
                      </el-col>
                      <el-col :span="8">
                        <div class="grid-content bg-purple-light">
                          <img alt="" src="../assets/frontimg/裙子.png"
                               style="width: 60%;height: 60%;margin-top: 10px;margin-left: 10px;">
                        </div>
                      </el-col>
                      <el-col :span="8">
                        <div class="grid-content bg-purple">
                          <img alt="" src="../assets/frontimg/裤子.png"
                               style="width: 80%;height: 80%;">
                        </div>
                      </el-col>
                    </el-row>
                    <el-row style="height:40px;">
                      <el-col :span="8">
                        <div class="grid-content" style="font-size:16px;font-family: '华文中宋';">上衣</div>
                      </el-col>
                      <el-col :span="8">
                        <div class="grid-content" style="font-size:16px;font-family: '华文中宋';">裙子</div>
                      </el-col>
                      <el-col :span="8">
                        <div class="grid-content" style="font-size:16px;font-family: '华文中宋';">裤子</div>
                      </el-col>
                    </el-row>
                    <el-row style="height:75px;">
                      <el-col :span="8">
                        <div class="grid-content bg-purple">
                          <img alt="" src="../assets/frontimg/家电.png"
                               style="width: 70%;height: 90%;margin-top: 20px;">
                        </div>
                      </el-col>
                      <el-col :span="8">
                        <div class="grid-content bg-purple-light">
                          <img alt="" src="../assets/frontimg/母婴·.png"
                               style="width: 60%;height: 60%;margin-top: 10px;margin-left: 10px;">
                        </div>
                      </el-col>
                      <el-col :span="8">
                        <div class="grid-content bg-purple">
                          <img alt="" src="../assets/frontimg/数码.png"
                               style="width: 60%;height: 60%;margin-top: 25px;">
                        </div>
                      </el-col>
                    </el-row>
                    <el-row style="height:40px;">
                      <el-col :span="8">
                        <div class="grid-content" style="font-size:16px;font-family: '华文中宋';">家电</div>
                      </el-col>
                      <el-col :span="8">
                        <div class="grid-content" style="font-size:16px;font-family: '华文中宋';">母婴</div>
                      </el-col>
                      <el-col :span="8">
                        <div class="grid-content" style="font-size:16px;font-family: '华文中宋';">数码</div>
                      </el-col>
                    </el-row>
                    <el-row style="height:80px;">
                      <el-col :span="8">
                        <div class="grid-content bg-purple">
                          <img alt="" src="../assets/frontimg/鞋子.png"
                               style="width: 85%;height: 85%;margin-top: 20px;">
                        </div>
                      </el-col>
                      <el-col :span="8">
                        <div class="grid-content bg-purple-light">
                          <img alt="" src="../assets/frontimg/香水.png"
                               style="width: 50%;height: 50%;margin-top: 10px;">
                        </div>
                      </el-col>
                      <el-col :span="8">
                        <div class="grid-content bg-purple">
                          <img alt="" src="../assets/frontimg/包包.png"
                               style="width: 75%;height: 75%;margin-top: 5px;">
                        </div>
                      </el-col>
                    </el-row>
                    <el-row style="height:40px;">
                      <el-col :span="8">
                        <div class="grid-content" style="font-size:16px;font-family: '华文中宋';">鞋子</div>
                      </el-col>
                      <el-col :span="8">
                        <div class="grid-content" style="font-size:16px;font-family: '华文中宋';">香水</div>
                      </el-col>
                      <el-col :span="8">
                        <div class="grid-content" style="font-size:16px;font-family: '华文中宋';">包包</div>
                      </el-col>
                    </el-row>
                    <el-row style="height:70px;">
                      <el-col :span="8">
                        <div class="grid-content bg-purple">
                          <img alt="" src="../assets/frontimg/上衣.png"
                               style="width: 80%;height: 100%;">
                        </div>
                      </el-col>
                      <el-col :span="8">
                        <div class="grid-content bg-purple-light">
                          <img alt="" src="../assets/frontimg/裙子.png"
                               style="width: 60%;height: 60%;margin-top: 10px;margin-left: 10px;">
                        </div>
                      </el-col>
                      <el-col :span="8">
                        <div class="grid-content bg-purple">
                          <img alt="" src="../assets/frontimg/裤子.png"
                               style="width: 80%;height: 80%;">
                        </div>
                      </el-col>
                    </el-row>
                    <el-row style="height:40px;">
                      <el-col :span="8">
                        <div class="grid-content" style="font-size:16px;font-family: '华文中宋';">上衣</div>
                      </el-col>
                      <el-col :span="8">
                        <div class="grid-content" style="font-size:16px;font-family: '华文中宋';">裙子</div>
                      </el-col>
                      <el-col :span="8">
                        <div class="grid-content" style="font-size:16px;font-family: '华文中宋';">裤子</div>
                      </el-col>
                    </el-row>
                  </div>
                </div>
              </div>
            </el-col>
          </el-row>
        </div>
      </el-main>
      <el-footer>
        <el-row>
          <div class="wp">
            <el-col :span="4">
              <div class="grid-content bg-purple">
                <div class="dh">
                  <el-menu
                      class="el-menu-vertical-demo"
                      default-active="2"
                      style="font-size: 25px;">
                    <el-menu-item index="2" style="color:orangered">
                      <i class="el-icon-menu"></i>
                      <span slot="title">品牌衣物</span>
                    </el-menu-item>
                    <el-submenu index="1">
                      <template slot="title">
                        <i class="el-icon-goods"></i>
                        <span>大牌化妆</span>
                      </template>
                      <el-menu-item-group>
                        <el-menu-item index="1-1">口红</el-menu-item>
                        <el-menu-item index="1-2">眼影</el-menu-item>
                        <el-menu-item index="1-3">美瞳</el-menu-item>
                      </el-menu-item-group>
                    </el-submenu>
                    <el-menu-item index="3">
                      <i class="el-icon-monitor"></i>
                      <span slot="title">家用电器</span>
                    </el-menu-item>
                    <el-menu-item index="4">
                      <i class="el-icon-camera"></i>
                      <span slot="title">数码机器</span>
                    </el-menu-item>
                  </el-menu>
                </div>
              </div>
            </el-col>
            <el-col :span="19">
              <div class="grid-content bg-purple-light">
                <el-row>
                  <el-col :span="9">
                    <div class="grid-content bg-purple" style="padding-left:200px;margin-top: 20px;">
                      <hr>
                    </div>
                  </el-col>
                  <el-col :span="5">
                    <div class="grid-content bg-purple-light"
                         style="font-size:30px;padding-bottom: 50px;color:orangered">
                      热 卖 精 品
                    </div>
                  </el-col>
                  <el-col :span="10">
                    <div class="grid-content bg-purple" style="padding-right:260px;margin-top: 20px;">
                      <hr>
                    </div>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="8">
                    <div class="grid-content bg-purple">
                      <div class="kuang" style="margin-left:80px">
                        <img src="../assets/frontimg/上衣.png"
                             style="width:200px;height: 200px;"><br>
                        <span>针织开衫外套女秋季显瘦V领短款纯色亲肤柔软针织衫甜美百搭</span><br>
                        <div style="margin-top:10px;margin-left: 10px;">
                          <span style="font-size:20px;color:red;margin-right: 10px;">￥199.00 </span>
                          <el-button icon="el-icon-shopping-cart-full" style="font-family: '宋体';margin-bottom: 15px;"
                                     type="danger">加入购物车
                          </el-button>
                        </div>
                      </div>
                    </div>
                  </el-col>
                  <el-col :span="8">
                    <div class="grid-content bg-purple-light">
                      <div class="kuang" style="margin-left:40px">
                        <img src="../assets/frontimg/母婴·.png"
                             style="width:200px;height: 200px;"><br>
                        <span>Qee IP热卖爆款童装男孩长袖T恤男童中大童冬季洋气体恤</span><br>
                        <div style="margin-top:10px;margin-left: 10px;">
                          <span style="font-size:20px;color:red;margin-right: 10px;">￥169.00 </span>
                          <el-button icon="el-icon-shopping-cart-full" style="font-family: '宋体';margin-bottom: 15px;"
                                     type="danger">加入购物车
                          </el-button>
                        </div>
                      </div>
                    </div>
                  </el-col>
                  <el-col :span="8">
                    <div class="grid-content bg-purple">
                      <div class="kuang">
                        <img src="../assets/frontimg/裤子.png"
                             style="width:200px;height: 200px;"><br>
                        <span>针男童运动长裤春秋2022新款中大童韩版儿童春秋薄款</span><br>
                        <div style="margin-top:10px;margin-left: 10px;">
                          <span style="font-size:20px;color:red;margin-right: 10px;">￥99.99 </span>
                          <el-button icon="el-icon-shopping-cart-full" style="font-family: '宋体';margin-bottom: 15px;"
                                     type="danger">加入购物车
                          </el-button>
                        </div>
                      </div>
                    </div>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="8">
                    <div class="grid-content bg-purple" style="margin-bottom:30px">
                      <div class="kuang" style="margin-left:80px">
                        <img src="../assets/frontimg/裙子.png"
                             style="width:200px;height: 190px;margin-top: 10px;"><br>
                        <span>针织开衫外套女秋季显瘦V领短款纯色亲肤柔软针织衫甜美百搭</span><br>
                        <div style="margin-top:10px;margin-left: 10px;">
                          <span style="font-size:20px;color:red;margin-right: 10px;">￥158.00 </span>
                          <el-button icon="el-icon-shopping-cart-full" style="font-family: '宋体';margin-bottom: 15px;"
                                     type="danger">加入购物车
                          </el-button>
                        </div>
                      </div>
                    </div>
                  </el-col>
                  <el-col :span="8">
                    <div class="grid-content bg-purple-light">
                      <div class="kuang" style="margin-left:40px">
                        <img src="../assets/frontimg/鞋子.png"
                             style="width:250px;height: 170px;margin-bottom: 15px;margin-top: 15px;"><br>
                        <span>Qee IP热卖爆款童装男孩长袖T恤男童中大童冬季洋气体恤</span><br>
                        <div style="margin-top:10px;margin-left: 10px;">
                          <span style="font-size:20px;color:red;margin-right: 10px;">￥269.00 </span>
                          <el-button icon="el-icon-shopping-cart-full" style="font-family: '宋体';margin-bottom: 15px;"
                                     type="danger">加入购物车
                          </el-button>
                        </div>
                      </div>
                    </div>
                  </el-col>
                  <el-col :span="8">
                    <div class="grid-content bg-purple">
                      <div class="kuang">
                        <img src="../assets/frontimg/粉.png"
                             style="width:180px;height: 180px;margin-top: 20px;"><br>
                        <span>针男童运动长裤春秋2022新款中大童韩版儿童春秋薄款</span><br>
                        <div style="margin-top:10px;margin-left: 10px;">
                          <span style="font-size:20px;color:red;margin-right: 10px;">￥146.00 </span>
                          <el-button icon="el-icon-shopping-cart-full" style="font-family: '宋体';margin-bottom: 15px;"
                                     type="danger">加入购物车
                          </el-button>
                        </div>
                      </div>
                    </div>
                  </el-col>
                </el-row>
              </div>
            </el-col>
          </div>
        </el-row>
        <el-pagination
            :total="50"
            layout="prev, pager, next"
            style="margin-left:40px;margin-bottom: 40px;"
        >
        </el-pagination>
        <el-row>
          <el-col :span="24">
            <div class="grid-content bg-purple-dark" style="padding:0px 0px;margin:-25px -28px;">
              <img alt="" src="../assets/frontimg/页脚.png" style="width: 100%;">
            </div>
          </el-col>
        </el-row>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
export default {
  data() {
    return {
      activeIndex: '1',
      input3: '',
    }
  },
  methods: {
    handleSelect(key, keyPath) {

    }
  }
}
</script>

<style>
.el-menu-item:hover {
  cursor: pointer;
  color: orangered;
}

.no1 {
  font-size: 14px;
}

.me {
  height: 50px;
  width: 50px;
  border-radius: 50%;
  margin-bottom: 15px;
}

.le {
  padding: 0px 5px;
  padding-bottom: 20px;
  padding-left: 10px;
  height: 280px;
  position: relative;
  color: white;
}

.le img {
  width: 84%;
  height: 100%;
  border-radius: 10px;
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0;
  line-height: 400px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-image: url(../assets/frontimg/中.png);
  background-size: 110%;
}

.el-carousel__item:nth-child(2n+1) {
  background-image: url(../assets/frontimg/中1.png);
  background-size: 110%;
}

.block {
  margin-left: -5px;
}

.you {
  padding: 0px 20px;
  padding-left: 25px;
  padding-top: -10px;
}

.buy {
  margin-top: 20px;
}

.lsp {
  margin: 10px 40px;
  text-align: center;
  color: #111;
  display: flex;
}

.dh {
  width: 240px;
  margin-left: 20px;
  margin-top: 55px;
  color: orangered
}

.wp {
  margin: 10px -10px;
}

.kuang {
  border: 1px solid #ccc;
  width: 70%;
  padding: 10px 10px;
  margin-bottom: 45px;
  border-radius: 5px;
}
</style>