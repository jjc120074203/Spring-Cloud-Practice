package org.spring.cloud.common.utils;

/**
 * <p>
 * Description: 服务上传文件
 * <h3>路径规则</h3>
 * <ul>
 * 		<li>相对路径,并且标明注释信息</li>
 * 		<li>路径格式：前缀/功能模块/id【唯一】/类型/文件名称</li>
 * 		<li>前缀 ：普通图片 -/pfs | 包文件 -</li>
 * </ul>
 * </p>
 * 
 * @author chenjl
 * @date 2017-03-15
 * @version 1.0
 */
public enum ResourcePathEnum implements ResourcePath {
	// 服务/组件截屏存储路径
	SC_SCREENSHOT_PATH {

		private String pathPattern = "/pfs/%s/%s/screenshot/%s";
		
		@Override
		public String getPath(String model,String resourceId, String filename) {
			return String.format(this.pathPattern,model,resourceId, filename);
		}

	},
	// 服务/组件icon存储路径
	SC_ICON_PATH {

		private String pathPattern = "/pfs/%s/%s/icon/%s";

		@Override
		public String getPath(String model,String resourceId, String filename) {
			return String.format(this.pathPattern, model,resourceId, filename);
		}

	},
	// 服务二维码
	SC_QR_PATH {

		private String pathPattern = "/pfs/%s/%s/qr/%s";

		@Override
		public String getPath(String model,String resourceId, String filename) {
			return String.format(this.pathPattern, model,resourceId, filename);
		}

	},
	//修改 文件 路径 modfied by  chenjl 2017-7-20 ------------------start 
	//用户秘钥目录
	SC_USER_PRIVATE_KEY {
		private String pathPattern = "/data/users/%s/%s";
		@Override
		public String getPath(String userId,String filename, String temp) {
			return String.format(this.pathPattern, userId, filename,null);
		}
	},
	//工程包 data/projects/{projectsId}/sources/sources.json
	SC_PROJECT_SRC_PATH {
		private String pathPattern = "/data/projects/%s/sources/%s";
		@Override
		public String getPath(String projectsId, String filename,String model) {
			return String.format(this.pathPattern,projectsId, filename, null);
		}
	},
	//realse包
	//data/projects/{projectsId}/releases/{packageId}/sources.json
	SC_RELEASE_PACKAGE_PATH {
		private String pathPattern = "/data/projects/%s/releases/%s/%s";

		@Override
		public String getPath(String projectsId,String packageId, String filename) {
			return String.format(this.pathPattern, projectsId,packageId, filename);
		}
	},
	//data/pre_deploy/{applicationInstanceId}/sources.json
	SC_RELEASE_PRE_DEPLOY_PATH {
		private String pathPattern = "/data/pre_deploy/%s/%s";
		@Override
		public String getPath(String applicationInstanceId, String filename,String model) {
			return String.format(this.pathPattern,applicationInstanceId, filename, null);
		}
	},
	//data/deploy/{applicationInstanceId}/sources.json
	SC_RELEASE_DEPLOY_PATH {
		private String pathPattern = "/data/deploy/%s/%s";
		@Override
		public String getPath(String applicationInstanceId, String filename,String model) {
			return String.format(this.pathPattern,applicationInstanceId, filename, null);
		}
	},
	//修改 文件 路径 modfied by  chenjl 2017-7-20 ------------------end 
	// 项目媒体文件存储路径
	PROJECT_MEDIA_PATH {
		private String pathPattern = "/pfs/projects/%s/%s/media/%s";
		@Override
		public String getPath(String model,String resourceId, String filename) {
			return String.format(this.pathPattern,model, resourceId, filename);
		}
	},
	// 用户头像存储路径
	SC_USER_HEAD_PATH {

		private String pathPattern = "/pfs/%s/%s/head/%s";

		@Override
		public String getPath(String model,String resourceId, String filename) {
			return String.format(this.pathPattern, model,resourceId, filename);
		}
	};
}
