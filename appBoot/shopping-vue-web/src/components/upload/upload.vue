<template>
  <div>
    <el-upload
      id="btn"
      class="avatar-uploader"
      action="/api/boot/upload/picture"
      :show-file-list="false"
      :on-success="uploadSuccess"
      :before-upload="beforeAvatarUpload">
      <img v-if="imageUrl" :src="imageUrl" class="avatar">
      <i v-else class="el-icon-plus avatar-uploader-icon"></i>
    </el-upload>
  </div>


</template>

<script>
    export default {
        name: "upload",

        data() {
            return {
                imageUrl: "",
                url:{
                    upload: "/boot/upload/picture",
                    init: "/boot/upload/init"
                }
            };
        },
        methods: {
            uploadSuccess(res, file) {
                if(res.success){
                    this.imageUrl = URL.createObjectURL(file.raw);
                }
            },
            fileUpload(param){
                var that = this;
                let fileObject = param.file;
                let formData = new FormData();
                formData.set("file", fileObject);
                that.$post(that.url.upload, formData).then(resp=>{
                    if(resp.success){
                        debugger
                        that.handleAvatarSuccess(resp, file);
                    }
                    console.info(resp);

                })

            },
            handleAvatarSuccess(res, file) {
                this.imageUrl = URL.createObjectURL(file.raw);
            },
            beforeAvatarUpload(file) {
                const isJPG = file.type === 'image/jpeg';
                const isLt2M = file.size / 1024 / 1024 < 2;

                if (!isJPG) {
                    this.$message.error('上传头像图片只能是 JPG 格式!');
                }
                if (!isLt2M) {
                    this.$message.error('上传头像图片大小不能超过 2MB!');
                }
                return isJPG && isLt2M;
            },
        },
        mounted() {

        }
    }
</script>

<style>
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>
