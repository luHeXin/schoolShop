package com.lu.schoolShop.util;

public class PathUtil {
	//获取文件的分隔符
	private static String seperator = System.getProperty("file.separator");
	//项目图片根路径
	public static String getImgBasePath() {
		String os = System.getProperty("os.name");
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
			basePath = "D:/JAVA_places/schoolShop/picture";
		} else {
			basePath = "/home/lu/image";
		}
		basePath = basePath.replace("/", seperator);
		return basePath;
	}
	//项目图片子路径
	public static String getShopImagePath(long shopId) {
		String imagePath = "/upload/images/item/shop/" + shopId + "/";
		return imagePath.replace("/", seperator);
	}
	public static String getHeadLineImagePath() {
		String imagePath = "/upload/images/item/headtitle/";
		return imagePath.replace("/", seperator);
	}
	public static String getShopCategoryPath() {
		String imagePath = "/upload/images/item/shopcategory/";
		return imagePath.replace("/", seperator);
	}
}
