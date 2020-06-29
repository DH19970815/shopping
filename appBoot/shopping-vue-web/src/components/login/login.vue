<template>
  <div id="vm" class="dialog">
    <el-container>
      <div class="background">
        <el-main>
          <div class="login">
            <el-form status-icon label-width="100px" class="demo-ruleForm">
              <el-form-item prop="user">
                <el-input type="text" placeholder="登录账号" v-model="login.username" style="width:240px" prefix-icon="el-icon-edit" autofocus></el-input>
              </el-form-item>
              <el-form-item prop="password">
                <el-input type="password" placeholder="登录密码" v-model="login.password" style="width:240px" prefix-icon="el-icon-edit" autofocus></el-input>
              </el-form-item>

              <el-form-item>
                <el-button type="primary" @click="doLogin">提交</el-button>
              </el-form-item>
            </el-form>
          </div>
        </el-main>
      </div>
      <el-footer>Copyright ©2018 乐优商城</el-footer>
    </el-container>
  </div>
</template>
<script>
  require("../../../static/css/login.css")
  export default {
      data() {
          return {
              login: {
                  username: null,
                  password: null
              },
              url: {
                  login: "/boot/index0010/login"
              }
          }

      },
      methods: {
          doLogin: function (oEvent) {
              debugger
              let that = this;
              if (!that.login.username || !that.login.password) {
                  return false;
              }else{
                  that.$fetch(that.url.login).then(resp=>{
                      console.info(resp);

                  })
              }

          }
      },
  }
</script>
