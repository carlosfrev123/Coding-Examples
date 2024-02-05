const webpack = require('webpack');
const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  mode: process.env.NODE_ENV,
  // where we want our bundle to run
  entry: './client/index.js',
  plugins: [
    new HtmlWebpackPlugin({
      title: 'Development',
      template: 'index.html',
    }),
  ],
  // specify where to build bundle.js
  output: {
    path: path.join(__dirname, './build'),
    publicPath: '/',
    filename: 'bundle.js',
  },
  devServer: {
    // host: 'localhost',
    // port: 8080,
    // enable HMR on the devServer
    hot: true,
    static: {
      // match the output path
      directory: path.resolve(__dirname, './'),
      // match the output 'publicPath'
      publicPath: '/',
    },
    proxy: { '/api': 'http://localhost:3000' },
  },
  module: {
    rules: [
      // rule for loading JSX
      {
        test: /\.jsx?$/,
        exclude: /node_modules/,
        loader: 'babel-loader',
        options: {
          presets: ['@babel/env', '@babel/react'],
        },
      },
      // rule for loading SCSS
      {
        test: /scss$/,
        exclude: /node_modules/,
        use: ['style-loader', 'css-loader', 'sass-loader'],
      },
      // rules for loading.png
      {
        test: /\.(png|jpe?g|gif)$/i,
        use: [
          {
            loader: 'file-loader',
          },
        ],
      },
    ],
  },
};
// https://webpack.js.org/configuration/dev-server/
// https://webpack.js.org/loaders/sass-loader/
// https://webpack.js.org/loaders/style-loader/
// https://github.com/webpack/webpack-dev-server
// https://webpack.js.org/configuration/output/#outputpublicpath

