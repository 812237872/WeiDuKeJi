package com.wd.tech.data;

import retrofit2.http.POST;

/**
 * @Author: zhang
 * @Date: 2019/5/9 19:43
 * @Description:
 */
public class Content {
    public static String baseUrl="https://mobile.bwstudent.com/";
    public static String Register = "techApi/user/v1/register";
    public static  String Login = "techApi/user/v1/login";
    public static  String Community = "techApi/community/v1/findCommunityList";//社区列表(get参)
    public static String AddInvitation = "techApi/community/verify/v1/releasePost";//(post)发布帖子
    public static String DelInvitation= "techApi/community/verify/v1/deletePost";//删除帖子(支持批量删除)(delete)
    public static String AddGreat= "techApi/community/verify/v1/addCommunityGreat";//点赞(post)
    public static String CancelGreat = "techApi/community/verify/v1/cancelCommunityGreat";//取消点赞(delete)
    public static String CommentList = "techApi/community/v1/findCommunityCommentList";//社区评论列表（标签方式返参）(get参)
    public static String UserCommentList = "techApi/community/v1/findCommunityUserCommentList";//社区用户评论列表（bean方式返参）(get参)
    public static String AddComment= "techApi/community/verify/v1/addCommunityComment";//发布社区评论(post)
    public static String UserInvitation = "techApi/community/verify/v1/findMyPostById";// 我的帖子(get参)
    public static String QueryInvitation = "techApi/community/verify/v1/findUserPostById";//查询用户发布的帖子(get参)
}
