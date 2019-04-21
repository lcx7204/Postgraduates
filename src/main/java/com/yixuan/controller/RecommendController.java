package com.yixuan.controller;

import com.yixuan.common.ServerResponse;
import com.yixuan.entity.Recommend;
import com.yixuan.service.IFileService;
import com.yixuan.service.IRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author:linchengxin
 * @Date:2019/4/10 16:22
 */
@Controller
@RequestMapping(value = "/recommend")
public class RecommendController {

    @Autowired
    private IRecommendService iRecommendService;
    @Autowired
    private IFileService iFileService;
    @Value("${recommend.savePath}")
    private String recommendSavePath;
    @Value("${recommend.url}")
    private String url;

    /**
     * 添加推荐
     * @param recommend
     * @return
     */
    @RequestMapping(value = "/addRecommend",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addRecommend(@RequestBody Recommend recommend){
        String recommendId = UUID.randomUUID().toString().replace("-","");  //主键
        recommend.setRecommendId(recommendId);
        recommend.setPublishDate(new Date());
        return iRecommendService.addRecommend(recommend);
    }

    /**
     * 分页获取推荐信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getRecommendList",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getRecommendList(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum, @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        return iRecommendService.getRecommendList(pageNum,pageSize);
    }

    /**
     * 根据ID查询推荐详情
     * @param recommendId
     * @return
     */
    @RequestMapping(value = "/findRecommendById",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse findRecommendById(String recommendId){
        return iRecommendService.findRecommendById(recommendId);
    }

    /**
     * 修改推荐
     * @param recommend
     * @return
     */
    @RequestMapping(value = "/updateRecommend",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse updateRecommend(@RequestBody Recommend recommend){
        return iRecommendService.updateRecommend(recommend);
    }

    /**
     * 删除推荐
     * @param recommendId
     * @return
     */
    @RequestMapping(value = "/deleteRecommend",method = RequestMethod.DELETE)
    @ResponseBody
    public ServerResponse deleteRecommend(String recommendId){
        return iRecommendService.deleteRecommend(recommendId);
    }

    /**
     * 推荐模块上传图片
     * @param file
     * @param response
     * @return
     */
    @RequestMapping(value = "/recommendUpload",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Map<String,String> uploadPic(@RequestParam(value = "upload_file",required = false) MultipartFile file, HttpServletResponse response){
        //开始上传图片
        Map<String,String> map = new HashMap<>();
        String path = recommendSavePath;
        String targetFileName = iFileService.upload(file,path);
        if (targetFileName =="" || targetFileName.isEmpty()){
            String msg = "上传失败";
            map.put("msg",msg);
            return map;
        }
        String newUrl = url + targetFileName;
        map.put("dialogImageUrl",newUrl);
        map.put("recommendIcon",targetFileName);
        response.addHeader("Access-Control-Allow-Headers","X-File-Name");
        return map;
    }

    /**
     * 根据分类获取推荐列表
     * @param recommendCategory
     * @return
     */
    @RequestMapping(value = "/wxGetRecommentListByCategory",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse wxGetRecommentListByCategory(String recommendCategory){
        return iRecommendService.wxGetRecommentListByCategory(recommendCategory);
    }
}
