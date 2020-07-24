package org.shopping.boot.common.service.Impl;

import org.shopping.boot.common.api.vo.Result;
import org.shopping.boot.common.service.FileCommonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class fileCommonServiceImpl implements FileCommonService {
    @Override
    public Result uploadFile(MultipartFile file) throws IOException {
        Result<?> result = new Result<>();
        if(!file.isEmpty()){
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                File entity = new File("E://upload-boot/" +sdf.format(new Date()));
                try {
                    if(!entity.exists()){
                        boolean ok = entity.mkdir();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    result.error500("文件夹创建失败");
                    System.out.println("1");
                }
                if(entity.exists()){
                    file.transferTo(new File("E:\\upload-boot\\" +entity.getName() +"\\" +file.getOriginalFilename()));
                    result.isSuccess();
                    result.setMessage("上传成功");
                }
            }catch (Exception e){
                e.printStackTrace();
                result.error500("上传失败");
                System.out.println("2");
            }


        }else {
            result.error500("上传失败");
        }
        return result;
    }
//    @Transactional
//    @Override
//    public Result<?> uploadFile(MultipartFile file) throws IOException {
//        Result<?> result = new Result();
//        InputStream input = null;
//        FileOutputStream out = null;
//        try {
//            input = file.getInputStream();
//            out = new FileOutputStream("E:\\微信小程序\\boot\\appBoot\\shopping-boot-parent\\upload\\" +file.getOriginalFilename());
//            byte[] array = new byte[1024];
//            while(input.read(array)!=-1){
//                out.write(array);
//            }
//            out.flush();
//        }catch (Exception e){
//            e.printStackTrace();
//            out.close();
//            input.close();
//            File entity = new File("E:\\微信小程序\\boot\\appBoot\\shopping-boot-parent\\upload\\" +file.getOriginalFilename());
//            if(entity.isFile() && entity.exists()){
//                entity.delete();
//            }
//            throw new RuntimeException();
//        }finally {
//            out.close();
//            input.close();
//        }
//        result.setSuccess(true);
//        return result;
//    }
}
