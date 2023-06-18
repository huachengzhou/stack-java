

# Testng翻译

> org.testng.annotations.Test
```
 /**
   * 此类/方法所属的组列表。
   */
  public String[] groups() default {};

  /**
   * 是否启用此类/方法上的方法。
   */
  public boolean enabled() default true;

  /**
  *用于填充此方法参数的变量列表。
  *这些变量必须在属性文件中定义。
   *
   * @deprecated Use @Parameters
   */
  @Deprecated
  public String[] parameters() default {};

  /**
   * The list of groups this method depends on.  Every method
   * member of one of these groups is guaranteed to have been
   * invoked before this method.  Furthermore, if any of these
   * methods was not a SUCCESS, this test method will not be
   * run and will be flagged as a SKIP.
   */
  public String[] dependsOnGroups() default {};

  /**
   * The list of methods this method depends on.  There is no guarantee
   * on the order on which the methods depended upon will be run, but you
   * are guaranteed that all these methods will be run before the test method
   * that contains this annotation is run.  Furthermore, if any of these
   * methods was not a SUCCESS, this test method will not be
   * run and will be flagged as a SKIP.
   *
   * If some of these methods have been overloaded, all the overloaded
   * versions will be run.
   */
  public String[] dependsOnMethods() default {};

  /**
  此测试应花费的最大毫秒数。
  如果此时间后未返回，则将标记为失败。
   */
  public long timeOut() default 0;

  /**
  本试验方法中的最大数毫秒引用总数应采用。如果该方法中没有具体说明引用的属性，则此注释将不清楚。如果这段时间后还没有回来，那将是一个失败。
   */
  public long invocationTimeOut() default 0;

  /**
   * 应调用此方法的次数。
   */
  public int invocationCount() default 1;

  /**
   * 此方法的线程池的大小。
   * 该方法将从invocationCount指定的多个线程中调用。
   * 注意:  如果未指定invocationCount，则忽略此属性。
   */
  public int threadPoolSize() default 0;

  /**
   * 此方法预期的成功百分比。
   */
  public int successPercentage() default 100;

  /**
   * 此测试方法的数据提供程序的名称。
   * @see org.testng.annotations.DataProvider
   */
  public String dataProvider() default "";

  /**
   * The class where to look for the data provider.  If not
   * specified, the dataprovider will be looked on the class
   * of the current test method or one of its super classes.
   * If this attribute is specified, the data provider method
   * needs to be static on the specified class.
   */
  public Class<?> dataProviderClass() default Object.class;

  /**
   如果设置为true，则即使此测试方法依赖于
   
   在失败的方法上。如果此测试
   
   不依赖任何方法或组。
   */
  public boolean alwaysRun() default false;

  /**
  此方法的说明。使用的字符串将出现在
  
  如果verbose大于等于2，也可以在标准输出上显示HTML报告。
   */
  public String description() default "";

  /**
   * The list of exceptions that a test method is expected to throw.  If no
   * exception or a different than one on this list is thrown, this test will be
   * marked a failure.
   */
  public Class[] expectedExceptions() default {};

  /**
  如果指定了ExpectedExceptions，则其消息必须与此属性中指定的正则表达式匹配。
   */
  public String expectedExceptionsMessageRegExp() default ".*";

  /**
 此测试类应放入的套件的名称。这个
 
 如果@test不在类级别，则忽略属性。
   */
  public String suiteName() default "";

  /**
   应放置此测试类的测试的名称。这个
   
   如果@test不在类级别，则忽略属性。
   */
  public String testName() default "";

  /**
   * @不推荐使用单线程
   */
  public boolean sequential() default false;

  /**
  *如果设置为true，则确保此测试类上的所有方法都运行
  
  *在同一线程中，即使测试当前正以parallel=“true”运行。
  
  *
  
  *此属性只能在类级别使用，将被忽略
  
  *如果在方法级别使用。
   */
  public boolean singleThreaded() default false;

  /**
   * The name of the class that should be called to test if the test
   * should be retried.
   * @return String The name of the class that will test if a test method
   * should be retried.
   */
  public Class retryAnalyzer() default Class.class;

  /**
   * If true and invocationCount is specified with a value > 1,
   * then all invocations after a failure will be marked as a SKIP
   * instead of a FAIL.
   */
  public boolean skipFailedInvocations() default false;

  /**
   * If set to true, this test will run even if the methods
   * it depends on are missing or excluded.
   */
  public boolean ignoreMissingDependencies() default false;

  /**
   * 调度优先级。优先安排较低的优先级。
   */
  int priority() default 0;
```