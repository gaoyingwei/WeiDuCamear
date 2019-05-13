package com.bw.movie.util;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface Api {
    //注册
    @FormUrlEncoded
    @POST("movieApi/user/v1/registerUser")
    public Observable<ResponseBody>getRegist(@Field("nickName") String nickName, @Field("sex") int sex, @Field("data") String data, @Field("phone") String phone, @Field("email") String email, @Field("pwd") String pwd,@Field("pwd2") String pwd2);
    //登录
    @FormUrlEncoded
    @POST("movieApi/user/v1/login")
    public Observable<ResponseBody>getLogin(@Field("phone")String phone,@Field("pwd")String pwd,@Field("pwd2")String pwd2);
    //baner轮播
    @GET("movieApi/movie/v1/findHotMovieList")
    public Observable<ResponseBody>getBaner(@Header("userId")int userId,@Header("sessionId")String sessionId,@Query("page")int page,@Query("count")int count);
    //热门电影
    @GET("movieApi/movie/v1/findHotMovieList")
    public Observable<ResponseBody>getHot(@Header("userId")int userId,@Header("sessionId")String sessionId,@Query("page")int page,@Query("count")int count);
    //正在热映
    @GET("movieApi/movie/v1/findReleaseMovieList")
    public Observable<ResponseBody>getYing(@Header("userId")int userId,@Header("sessionId")String sessionId,@Query("page")int page,@Query("count")int count);
    //即将上映
    @GET("movieApi/movie/v1/findComingSoonMovieList")
    public Observable<ResponseBody>getJiJiang(@Header("userId")int userId,@Header("sessionId")String sessionId,@Query("page")int page,@Query("count")int count);
    //电影详情
    @GET("movieApi/movie/v1/findMoviesDetail")
    public Observable<ResponseBody>getXiang(@Header("userId")int userId,@Header("sessionId")String sessionId,@Query("movieId")int movieId);
    //热门电影
    @GET("movieApi/movie/v1/findHotMovieList")
    public Observable<ResponseBody>getRemen(@Header("userId")int userId,@Header("sessionId")String sessionId,@Query("page")int page,@Query("count")int count);
    //正在热映
    @GET("movieApi/movie/v1/findReleaseMovieList")
    public Observable<ResponseBody>getNow(@Header("userId")int userId,@Header("sessionId")String sessionId,@Query("page")int page,@Query("count")int count);
    //即将上映
    @GET("movieApi/movie/v1/findComingSoonMovieList")
    public Observable<ResponseBody>getJi(@Header("userId")int userId,@Header("sessionId")String sessionId,@Query("page")int page,@Query("count")int count);

}
