/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cvds.samples.services.client;



import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.mybatis.mappers.CargoMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.HorarioMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.UsuarioMapper;
import edu.eci.cvds.samples.entities.Cargo;
import edu.eci.cvds.samples.entities.Horario;



/**
 *
 * @author hcadavid
 */
public class MyBatisExample {

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream=null;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);                
            } 
          
            
           catch (IOException e) {
                throw new RuntimeException(e.getCause());
           }
        }
        return sqlSessionFactory;
    }

  
    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException 
     */
    public static void main(String args[]) throws SQLException {
    	SqlSessionFactory sessionfact = getSqlSessionFactory();
    	SqlSession sqlss = sessionfact.openSession();
    	
    	
   
    	/*SimpleDateFormat format =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    	
        String dateInString = "31/08/1982 10:20:56";Date date = null;
    	try {
			date = format.parse(dateInString);
			System.out.println(date); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        List<Date> horas=new ArrayList<Date>();
        horas.add(date);
        HorarioMapper hm=sqlss.getMapper(HorarioMapper.class);
        hm.actualizarHoras(1, horas);
        */
    	sqlss.commit();
        sqlss.close();
        
        
    }


}