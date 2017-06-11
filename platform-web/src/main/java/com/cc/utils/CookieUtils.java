package com.cc.utils;

import com.cc.domain.WebConstants;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chengcheng on 2017/6/11.
 */
public abstract class CookieUtils {

    /******************使用Cookie保存MemberId**************************/
    public static void setMemberId(HttpServletRequest request,HttpServletResponse response,String memberId){
        Cookie cookie = new Cookie(WebConstants.COOKIE_MEMBERID,memberId);
        cookie = cookieBuild(request,cookie);
        response.addCookie(cookie);
    }
    public static String getMemberId(HttpServletRequest request){
        Object memberId = ReadCookieMap(request).get(WebConstants.COOKIE_MEMBERID);
        if(memberId instanceof String){
            return (String)memberId;
        }
        return "";
    }
    /******************使用Cookie保存MemberId**************************/




    /******************使用Cookie保存Ticket**************************/
    public static void setTicket(HttpServletRequest request,HttpServletResponse response,String ticket){
        Cookie cookie = new Cookie(WebConstants.COOKIE_TICKET, ticket);
        cookie = cookieBuild(request,cookie);
        response.addCookie(cookie);
    }
    public static String getTicket(HttpServletRequest request){
        Object ticket = ReadCookieMap(request).get(WebConstants.COOKIE_TICKET);
        if (ticket instanceof String){
            return (String)ticket;
        }
        return "";
    }
    /******************使用Cookie保存Ticket**************************/



    /******************使用Cookie保存Cid**************************/
    public static void setCid(HttpServletRequest request,HttpServletResponse response,String cid){
        Cookie cookie = new Cookie(WebConstants.COOKIE_CID, cid);
        cookie = cookieBuild(request,cookie);
        response.addCookie(cookie);
    }
    public static String getCid(HttpServletRequest request){
        Object cid = ReadCookieMap(request).get(WebConstants.COOKIE_CID);
        if (cid instanceof String){
            return (String)cid;
        }
        return "";
    }
    /******************使用Cookie保存Cid**************************/




    private static Cookie cookieBuild(HttpServletRequest request, Cookie cookie){
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(1);
//        cookie.setDomain(getDomain(request));
        return cookie;
    }

    public static String getDomain(HttpServletRequest request){
        StringBuffer url = request.getRequestURL();
        int length=url.length();
        String tempContextUrl = url.delete(length - request.getRequestURI().length(), length).toString();
        return StringUtils.substring(tempContextUrl,tempContextUrl.indexOf("."));
    }

    private static Map ReadCookieMap(HttpServletRequest request){
        Map cookieMap = new HashMap();
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie: cookies){
            if(null != cookie){
                cookieMap.put(cookie.getName(),cookie);
            }
        }
        return cookieMap;
    }

    private static Cookie clearCookie(Cookie cookie){
        cookie.setMaxAge(0);
        cookie.setValue(null);
        cookie.setPath("/");
//        cookie.setDomain(environmentService.getCookieDomain());
        return cookie;
    }

}
