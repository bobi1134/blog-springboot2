/*************************************************************
 *
 *  /MathJax/unpacked/config/TeX-MML-AM_CHTML.js
 *  
 *  Copyright (c) 2010-2016 The MathJax Consortium
 *
 *  Part of the MathJax library.
 *  See http://www.mathjax.org for details.
 * 
 *  Licensed under the Apache License, Version 2.0;
 *  you may not use this file except in compliance with the License.
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 */
MathJax.Hub.Config({
  showProcessingMessages: false, //关闭js加载过程信息
  messageStyle: "none", //不显示信息
  tex2jax: {
    inlineMath: [ ['$','$'], ["\\(","\\)"] ], //行内公式选择符
    displayMath: [ ['$$','$$'], ["\\[","\\]"] ], //段内公式选择符
    skipTags: ['script', 'noscript', 'style', 'textarea', 'pre','code','a'], //避开某些标签
    ignoreClass:"comment-content" //避开含该Class的标签
  },
  TeX: {
    Macros: {
      RR: '{\\bf R}',                // a simple string replacement
      bold: ['\\boldsymbol{#1}',1],   // this macro has one parameter
      equationNumbers: {autoNumber: "AMS"}
    }
  },
  "HTML-CSS": {
    availableFonts: ["STIX","TeX"],
    showMathMenu: false //关闭右击菜单显示
  },
  extensions: ["tex2jax.js","mml2jax.js","asciimath2jax.js","MathEvents.js","MathZoom.js","MathMenu.js","toMathML.js","TeX/noErrors.js","TeX/noUndefined.js","TeX/AMSmath.js","TeX/AMSsymbols.js","fast-preview.js","AssistiveMML.js","[Contrib]/a11y/accessibility-menu.js"],
  jax: ["input/TeX","input/MathML","input/AsciiMath","output/CommonHTML","output/PreviewHTML","output/HTML-CSS"]
});

MathJax.Ajax.loadComplete("[MathJax]/config/TeX-MML-AM_CHTML.js");
