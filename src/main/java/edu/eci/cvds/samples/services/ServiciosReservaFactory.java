package edu.eci.cvds.samples.services;

import com.google.inject.Injector;

import edu.eci.cvds.sampleprj.dao.CargoDAO;
import edu.eci.cvds.sampleprj.dao.RecursoDAO;
import edu.eci.cvds.sampleprj.dao.ReservaDAO;
import edu.eci.cvds.sampleprj.dao.TipoDAO;
import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBatisCargoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBatisRecursoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBatisReservaDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBatisTipoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBatisUsuarioDAO;
import edu.eci.cvds.samples.services.impl.ServiciosReservaImpl;

import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.XMLMyBatisModule;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class ServiciosReservaFactory {

   private static ServiciosReservaFactory instance = new ServiciosReservaFactory();

   private static Optional<Injector> optInjector;

   private Injector myBatisInjector(final String env, final String pathResource) {
       return createInjector(new XMLMyBatisModule() {
           @Override
           protected void initialize() {
               setEnvironmentId(env);
               setClassPathResource(pathResource);
               bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
               bind(CargoDAO.class).to(MyBatisCargoDAO.class);
               bind(TipoDAO.class).to(MyBatisTipoDAO.class);
               bind(RecursoDAO.class).to(MyBatisRecursoDAO.class);
               bind(ReservaDAO.class).to(MyBatisReservaDAO.class);
               bind(ServiciosReserva.class).to(ServiciosReservaImpl.class);
           }
       });
   }

   private ServiciosReservaFactory(){
       optInjector = Optional.empty();
   }

   public ServiciosReserva getServiciosAlquiler(){
       if (!optInjector.isPresent()) {
           optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
       }

       return optInjector.get().getInstance(ServiciosReserva.class);
   }


   /*public ServiciosAlquiler getServiciosAlquilerTesting(){
       if (!optInjector.isPresent()) {
           optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
       }

       return optInjector.get().getInstance(ServiciosAlquiler.class);
   }*/


   public static ServiciosReservaFactory getInstance(){
       return instance;
   }

}