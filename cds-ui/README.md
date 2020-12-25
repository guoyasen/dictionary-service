全称：Quantex Design Pro 前端开箱即用脚手架

## 框架介绍

- **核心技术栈**：Electron + React + ES6/TypeScripts + MobX + Antd + Webpack + NodeJS
- **CSS 技术栈**：Sass + css-modules + AutoPrefixer + iconfont
- **代码质量检测**：Eslint + Htmlhint + Csslint
- **调试工具**：Electon + React DevTools + MobX DevTools
- **开发服务**: Eggjs

## 开发指引

### 常用命令

1. `npm install` #安装依赖
2. `npm start` #runing development mode
3. `npm run dist` #runing production mode

> 项目运行需要配合 BFF 服务，具体请参考该服务 README

### 主题开发

1. `npm run theme` # 该命令会监听 app/styles/theme 下的文件变动，并重新编译打包
2. `npm run start` #runing development mode
   > 主题开发暂不支持热更新，也即每次修改主题代码后，都需要刷新浏览器（但不需要重新 npm start)
