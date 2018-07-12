package com.example.tongxiwen.constellationtest.util;

import android.text.TextUtils;

import com.example.tongxiwen.constellationtest.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ConstellationUtil {

    private static final Map<String, Integer> imageMap;
    private static final Map<String, String> regionMap;
    static {
        imageMap = new HashMap<>();
        imageMap.put("白羊座", R.drawable.aries);
        imageMap.put("金牛座", R.drawable.taurus);
        imageMap.put("双子座", R.drawable.gemini);
        imageMap.put("巨蟹座", R.drawable.cancer);
        imageMap.put("狮子座", R.drawable.leo);
        imageMap.put("处女座", R.drawable.virgo);
        imageMap.put("天秤座", R.drawable.libra);
        imageMap.put("天蝎座", R.drawable.scorpio);
        imageMap.put("射手座", R.drawable.sagittarius);
        imageMap.put("摩羯座", R.drawable.capricorn);
        imageMap.put("水瓶座", R.drawable.aquarius);
        imageMap.put("双鱼座", R.drawable.pisces);

        regionMap = new HashMap<>();
        regionMap.put("白羊座", "03/21~04/19");
        regionMap.put("金牛座", "04/20~05/20");
        regionMap.put("双子座", "05/21~06/21");
        regionMap.put("巨蟹座", "06/22~07/22");
        regionMap.put("狮子座", "07/23~08/22");
        regionMap.put("处女座", "08/23~09/22");
        regionMap.put("天秤座", "09/23~10/23");
        regionMap.put("天蝎座", "10/24~11/22");
        regionMap.put("射手座", "11/23~12/21");
        regionMap.put("摩羯座", "12/22~01/19");
        regionMap.put("水瓶座", "01/20~02/18");
        regionMap.put("双鱼座", "02/19~03/20");
    }

    public static int getImageSrcByName(String name){
        return TextUtils.isEmpty(name) ? 0 : imageMap.get(name);
    }

    public static String getDateRegionByName(String name){
        return regionMap.get(name);
    }
}
