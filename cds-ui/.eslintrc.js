// webpack config
const path = require('path');
require('ts-node/register/transpile-only');
const projectConfig = require('./config/config');
const scriptsPath = projectConfig.webpackConfig.resolveAlias['quantex-scripts'] || 'quantex-scripts';

process.env.CONFIG_FILE = path.resolve('config/config');
process.env.THEME_CONFIG_FILE = path.resolve('theme.config.json');

const config = require(`${scriptsPath}/config/base.js`);

const eslintrc = {
  parser: 'babel-eslint',
  plugins: ['react'],
  globals: {
    logger: true,
    userLocalStore: true,
    electron: true,
  },
  settings: {
    // 解决webpack require各类文件报路径错误
    'import/resolver': {
      webpack: {
        config: {
          resolve: {
            extensions: config.resolve.extensions,
            alias: { ...config.resolve.alias, ...projectConfig.webpackConfig.resolveAlias },
          },
        },
      },
    },
  },
  parserOptions: {
    ecmaVersion: 6,
    sourceType: 'module',
    allowImportExportEverywhere: false,
    ecmaFeatures: {
      jsx: true,
    },
  },
  // 脚本运行环境,会决定存在哪些全局变量,比如brower会有window
  env: {
    browser: true,
    amd: true,
    es6: true,
    node: true,
    mocha: true,
  },
  // 以当前目录为根目录，不再向上查找 .eslintrc.js
  root: true,
  // 使用airbnb定义的规则集
  extends: ['airbnb-base'],
  // 使用自定义规则进行覆盖
  rules: {
    'react/jsx-uses-react': 1,
    'react/jsx-uses-vars': 1,
    'no-mixed-operators': 0,
    'comma-dangle': 0,
    'no-plusplus': 0,
    'import/no-dynamic-require': 0,
    'import/no-extraneous-dependencies': 0,
    'prefer-template': 0,
    'prefer-const': 0,
    'object-shorthand': 0,
    'global-require': 0,
    'no-unused-vars': 1,
    'no-console': 0,
    'class-methods-use-this': 0,
    'no-debugger': 0,
    'arrow-body-style': 0,
    quotes: 0,
    eqeqeq: 0,
    'max-len': 0,
    'dot-notation': 0,
    'no-underscore-dangle': 0,
    'guard-for-in': 0,
    'no-restricted-syntax': 0,
    'no-continue': 0,
    'quote-props': 0,
    'prefer-rest-params': 0,
    'no-unused-expressions': 0,
    'linebreak-style': 0,
    'no-else-return': 0,
    'no-lonely-if': 0,
    'no-prototype-builtins': 0,
    'no-param-reassign': 0,
    'no-bitwise': 0,
    'no-cond-assign': 0,
    'no-case-declarations': 0,
    'no-fallthrough': 0,
    'no-nested-ternary': 0,
    camelcase: 0,
    'import/no-named-as-default-member': 0,
    'func-names': 0,
    'no-useless-concat': 0,
    'no-use-before-define': ['error', { functions: false }],
    'no-alert': 0,
    'no-trailing-spaces': ['error', { skipBlankLines: true }],
    'no-multi-spaces': 'off',
    indent: 'off',
    'padded-blocks': 'off',
    'no-await-in-loop': 'off',
    'import/no-mutable-exports': 0,
    'arrow-parens': 0,
    curly: 0,
    'react/jsx-no-undef': 'error',
    'import/prefer-default-export': 0,
    'import/extensions': 0,
    'space-before-function-paren': 'off',
  },
};

module.exports = eslintrc;
