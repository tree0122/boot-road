### DispatcherServlet.render()

1. HttpServletResponse.setLocale(): 设置Locale
1. 获取 View
    - resolveViewName(): 通过视图解析器 解析视图
    - ModelAndView.getView(): mv中获取视图
1. View.render(): 渲染视图, 并通过Response返回数据    