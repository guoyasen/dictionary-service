// 注意！！修改该配置文件不会热更新，需要重新执行npm start
const npmScope = '@gza'; // 私有npm依赖的scope
const isDev = process.env.NODE_ENV === 'development';
const config: IConfig = {
  systemConfig: {
    devServerPort: 8888, // dev server 端口
    isPortal: false,
    npmScope: npmScope,
    godzillaLicenseKey:
      'quantex__2020_4_6_[TRIAL]_MTU4NjE4NTk0NTk5MQ==9053b0c05f8a201c1275e62579d7326f',
    agGridLicenseKey:
      'China_Merchants_Bank__multi_1_Devs__7_November_2020_[v2]_MTYwNDcwNzIwMDAwMA==fe663629062117b3018166f309ca7e9a',
  },
  apiConfig: {
    isDebug: isDev,
    base: isDev ? '' : '',
    domain: {},
  },
  definePlugin: {
    ENABLE_SSO: false, // 是否只允许sso登录
    APP_ID: JSON.stringify('cds'), // 应用ID
    PROJECT_NAME: JSON.stringify('Godzilla 门户'), // 应用名称
  },
  webpackConfig: {
    resolveAlias: {
      'quantex-utils': `${npmScope}/quantex-utils`,
      'quantex-design': `${npmScope}/quantex-design`,
      'quantex-scripts': `${npmScope}/quantex-scripts`,
      'quantex-scaffold': `${npmScope}/quantex-scaffold`,
    },
  },
  themeConfig: {
    defaultTheme: 'themeWhite',
    mainTheme: 'themeWhite',
    themes: [
      {
        name: '浅色',
        id: 'themeWhite',
      },
      {
        name: '深色',
        id: 'themeDark',
      },
    ],
  },
  pluginConfig: [
    [
      'theme-dark',
      {
        package: '@gza/quantex-plugin-theme-dark',
      },
    ],
    [
      'theme-hrxt-white',
      {
        package: '@gza/quantex-plugin-theme-hrxt-white',
      },
    ],
  ],
};

module.exports = config;

