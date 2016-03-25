package jian.com;



public class Upload {
    //@ResponseBody
    //@RequestMapping("/uploadFile")
    /*public String uploadFile(HttpServletRequest request,String id) {
        JSONObject json = new JSONObject();
        try {
            logger.debug("开始文件上传");
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            
            CommonsMultipartFile orginalFile = (CommonsMultipartFile) multipartRequest
                    .getFile("file");// 表单中对应的文件名；
            
            if (orginalFile != null && !orginalFile.isEmpty()) {// 如果有文章中带有附件
                String filename = orginalFile.getOriginalFilename();
                
                String root = request.getSession().getServletContext().getRealPath("");
                
                File file = new File(root, "upload");
                
                
                if(!file.exists()) file.mkdir();
                String separator = java.io.File.separator;
                // String realFileName = file.getAbsolutePath()+"\\"+ DateUtil.getTimeInMillis()+filename.substring(filename.lastIndexOf("."));
                String realFileName = file.getAbsolutePath()+ separator + new Date().getSeconds()+filename.substring(filename.lastIndexOf("."));
                
                DataOutputStream out = new DataOutputStream(
                        new FileOutputStream(realFileName));// 存放文件的绝对路径
                InputStream is = null;// 附件输入流
                try {
                    is = orginalFile.getInputStream();
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    out.write(b);
                } catch (IOException exception) {
                    exception.printStackTrace();
                } finally {
                    if (is != null) {
                        is.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                }
                
                String fileId = dfsAo.uploadPicture(realFileName);
                logger.info("上传图片至dfs,image key :" + fileId);
                File realFile = new File(realFileName);
                realFile.deleteOnExit();
                json.put("id", id);
                json.put("key", fileId);
            }
            
            
        } catch (Exception e) {
            logger.error("[ERROR]文件上传错误:"+e.getMessage(),e);
        }
        return json.toJSONString();
    }
*/
}
