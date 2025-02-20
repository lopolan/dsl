package ${backPackage}.config;



import com.github.shamil.Xid;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import io.vavr.jackson.datatype.VavrModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




public class Config{
  @Bean
  public CustomMetaObjectHandler customMetaObjectHandler() {
    return new CustomMetaObjectHandler();
  }
  @Bean
  public VavrModule vavrModule() {
    return new VavrModule();
  }

  @Bean
  public IdentifierGenerator identifierGenerator() {
    return new IdentifierGenerator() {
      @Override
      public Number nextId(Object entity) {
        return null;
      }

      @Override
      public String nextUUID(Object entity) {
        return Xid.string();
      }
    };
  }

  @Bean
  public MybatisPlusInterceptor mybatisPlusInterceptor() {
    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
    interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
    return interceptor;
  }
}
