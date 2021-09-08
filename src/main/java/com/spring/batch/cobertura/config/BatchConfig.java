package com.spring.batch.cobertura.config;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.batch.cobertura.dto.CentroBeneficioDTO;
import com.spring.batch.cobertura.dto.CentroLogCentroBenDTO;
import com.spring.batch.cobertura.dto.CentroLogisticoDTO;
import com.spring.batch.cobertura.dto.CuentaContableDTO;
import com.spring.batch.cobertura.dto.ServicioDTO;
import com.spring.batch.cobertura.dto.Tabla15DTO;
import com.spring.batch.cobertura.dto.ConfiguracionPresupuestoServicioDTO;
import com.spring.batch.cobertura.dto.UnidadNegocioDTO;
import com.spring.batch.cobertura.entity.CargaPortafolioTemp;
import com.spring.batch.cobertura.entity.CentroLogisticoTemp;
import com.spring.batch.cobertura.listener.JobCompletionListener;
import com.spring.batch.cobertura.step.ProcessorCentroLogPorCentroBen;
import com.spring.batch.cobertura.step.ProcessorCentrosBeneficio;
import com.spring.batch.cobertura.step.ProcessorCentrosLogisticos;
import com.spring.batch.cobertura.step.ProcessorCentrosWs;
import com.spring.batch.cobertura.step.ProcessorConfiguracionPresupuestoServicio;
import com.spring.batch.cobertura.step.ProcessorCuentasContables;
import com.spring.batch.cobertura.step.ProcessorServicios;
import com.spring.batch.cobertura.step.ProcessorTabla15;
import com.spring.batch.cobertura.step.ProcessorUnidadNegocios;
import com.spring.batch.cobertura.step.ProcessorWs;
import com.spring.batch.cobertura.step.ReaderCentroLogPorCentroBen;
import com.spring.batch.cobertura.step.ReaderCentrosBeneficio;
import com.spring.batch.cobertura.step.ReaderCentrosLogisticos;
import com.spring.batch.cobertura.step.ReaderCentrosWs;
import com.spring.batch.cobertura.step.ReaderConfiguracionPresupuestoServicio;
import com.spring.batch.cobertura.step.ReaderCuentasContables;
import com.spring.batch.cobertura.step.ReaderServicios;
import com.spring.batch.cobertura.step.ReaderTabla15;
import com.spring.batch.cobertura.step.ReaderUnidadNegocios;
import com.spring.batch.cobertura.step.ReaderWs;
import com.spring.batch.cobertura.step.WriterCentroLogPorCentroBen;
import com.spring.batch.cobertura.step.WriterCentrosBeneficio;
import com.spring.batch.cobertura.step.WriterCentrosLogisticos;
import com.spring.batch.cobertura.step.WriterCentrosWs;
import com.spring.batch.cobertura.step.WriterConfiguracionPresupuestoServicio;
import com.spring.batch.cobertura.step.WriterCuentasContables;
import com.spring.batch.cobertura.step.WriterServicios;
import com.spring.batch.cobertura.step.WriterTabla15;
import com.spring.batch.cobertura.step.WriterUnidadNegocios;
import com.spring.batch.cobertura.step.WriterWs;

@Configuration
@EnableBatchProcessing
@EnableCaching
public class BatchConfig extends DefaultBatchConfigurer {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public JobCompletionListener jobCompletionListener;

	@Override
	public void setDataSource(DataSource dataSource) {
	}

	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager();
	}

	@Bean("JobCargaCoberturaPortafolio")
	public Job processJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
			JobCompletionListener listener) {

		return jobBuilderFactory.get("JobCargaCoberturaPortafolio")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.start(obtenerInformacionSAPCentrosStep1(stepBuilderFactory))
				.next(obtenerInformacionSAPStep2(stepBuilderFactory))
				//.next(montarCuentasContables(stepBuilderFactory))
				//.next(montarCentrosLogisticos(stepBuilderFactory))
				//.next(montarTabla15(stepBuilderFactory))
				//.next(montarServicios(stepBuilderFactory))
				//.next(montarCentrosBeneficio(stepBuilderFactory))
				//.next(montarUnidadNegocios(stepBuilderFactory))
				//.next(montarCentroLogPorCentroBen(stepBuilderFactory))
				.next(montarConfiguracionPresupuestoServicio(stepBuilderFactory))
				.build();
	}

	@Bean
	public Step obtenerInformacionSAPCentrosStep1(StepBuilderFactory stepBuilderFactory) {
		return stepBuilderFactory.get("obtenerInformacionSAPCentrosStep1").<String, List<CentroLogisticoTemp>>chunk(1)
				.reader(interfazReaderCentrosWs()).processor(interfazProcessorCentrosWs())
				.writer(interfazWritterCentrosWs()).build();
	}

	@Bean
	public Step obtenerInformacionSAPStep2(StepBuilderFactory stepBuilderFactory) {
		return stepBuilderFactory.get("obtenerInformacionSAPStep2").<List<String>, List<CargaPortafolioTemp>>chunk(1)
				.reader(interfazReaderWs()).processor(interfazProcessorWs()).writer(interfazWritterWs()).build();
	}

	@Bean
	public Step montarCuentasContables(StepBuilderFactory stepBuilderFactory) {
		return stepBuilderFactory.get("montarCuentasContables").<List<Object[]>, List<CuentaContableDTO>>chunk(1)
				.reader(interfazReaderCuentasContables()).processor(interfazProcessorCuentasContables())
				.writer(interfazWritterCuentasContables()).build();
	}

	@Bean
	public Step montarCentrosLogisticos(StepBuilderFactory stepBuilderFactory) {
		return stepBuilderFactory.get("montarCentrosLogisticos").<List<CentroLogisticoTemp>, List<CentroLogisticoDTO>>chunk(1)
				.reader(interfazReaderCentrosLogisticos()).processor(interfazProcessorCentrosLogisticos())
				.writer(interfazWritterCentrosLogisticos()).build();
	}

	@Bean
	public Step montarCentrosBeneficio(StepBuilderFactory stepBuilderFactory) {
		return stepBuilderFactory.get("montarCentrosBeneficio").<List<Object[]>,  List<CentroBeneficioDTO>>chunk(1)
				.reader(interfazReaderCentrosBeneficio()).processor(interfazProcessorCentrosBeneficio())
				.writer(interfazWritterCentrosBeneficio()).build();
	}

	@Bean
	public Step montarCentroLogPorCentroBen(StepBuilderFactory stepBuilderFactory) {
		return stepBuilderFactory.get("montarCentroLogPorCentroBen").<List<Object[]>,  List<CentroLogCentroBenDTO>>chunk(1)
				.reader(interfazReaderCentroLogPorCentroBen()).processor(interfazProcessorCentroLogPorCentroBen())
				.writer(interfazWritterCentroLogPorCentroBen()).build();
	}

	@Bean
	public Step montarUnidadNegocios(StepBuilderFactory stepBuilderFactory) {
		return stepBuilderFactory.get("montarUnidadNegocios").<List<Object[]>,  List<UnidadNegocioDTO>>chunk(1)
				.reader(interfazReaderUnidadNegocios()).processor(interfazProcessorUnidadNegocios())
				.writer(interfazWritterUnidadNegocios()).build();
	}

	@Bean
	public Step montarConfiguracionPresupuestoServicio(StepBuilderFactory stepBuilderFactory) {
		return stepBuilderFactory.get("montarConfiguracionPresupuestoServicio").<List<Object[]>,List<ConfiguracionPresupuestoServicioDTO>>chunk(1)
				.reader(interfazReaderConfiguracionPresupuestoServicio()).processor(interfazProcessorConfiguracionPresupuestoServicio())
				.writer(interfazWritterConfiguracionPresupuestoServicio()).build();
	}

	@Bean
	public Step montarTabla15(StepBuilderFactory stepBuilderFactory) {
		return stepBuilderFactory.get("montarTabla15").<List<Object[]>,List<Tabla15DTO>>chunk(1).reader(interfazReaderTabla15())
				.processor(interfazProcessorTabla15()).writer(interfazWritterTabla15()).build();
	}

	@Bean
	public Step montarServicios(StepBuilderFactory stepBuilderFactory) {
		return stepBuilderFactory.get("montarServicios").<List<Object[]>,List<ServicioDTO>>chunk(1).reader(interfazReaderServicios())
				.processor(interfazProcessorServicios()).writer(interfazWritterServicios()).build();
	}

	@Bean
	public ItemReader<String> interfazReaderCentrosWs() {
		return new ReaderCentrosWs();
	}

	@Bean
	public ItemProcessor<String, List<CentroLogisticoTemp>> interfazProcessorCentrosWs() {
		return new ProcessorCentrosWs();
	}

	@Bean
	public ItemWriter<List<CentroLogisticoTemp>> interfazWritterCentrosWs() {
		return new WriterCentrosWs();
	}

	// obtener Informacion SAP Step2
	@Bean
	public ItemReader<List<String>> interfazReaderWs() {
		return new ReaderWs();
	}

	@Bean
	public ItemProcessor<List<String>, List<CargaPortafolioTemp>> interfazProcessorWs() {
		return new ProcessorWs();
	}

	@Bean
	public ItemWriter<List<CargaPortafolioTemp>> interfazWritterWs() {
		return new WriterWs();
	}

	// Montar Información cuentas contables
	@Bean
	public ItemReader<List<Object[]>> interfazReaderCuentasContables() {
		return new ReaderCuentasContables();
	}

	@Bean
	public ItemProcessor<List<Object[]>, List<CuentaContableDTO>> interfazProcessorCuentasContables() {
		return new ProcessorCuentasContables();
	}

	@Bean
	public ItemWriter<List<CuentaContableDTO>> interfazWritterCuentasContables() {
		return new WriterCuentasContables();
	}

	// Montar Información Centros Logisticos
	@Bean
	public ItemReader<List<CentroLogisticoTemp>> interfazReaderCentrosLogisticos() {
		return new ReaderCentrosLogisticos();
	}

	@Bean
	public ItemProcessor<List<CentroLogisticoTemp>, List<CentroLogisticoDTO>> interfazProcessorCentrosLogisticos() {
		return new ProcessorCentrosLogisticos();
	}

	@Bean
	public ItemWriter<List<CentroLogisticoDTO>> interfazWritterCentrosLogisticos() {
		return new WriterCentrosLogisticos();
	}

	// MOntar Información Centros Beneficio
	@Bean
	public ItemReader<List<Object[]>> interfazReaderCentrosBeneficio() {
		return new ReaderCentrosBeneficio();
	}

	@Bean
	public ItemProcessor<List<Object[]>, List<CentroBeneficioDTO>> interfazProcessorCentrosBeneficio() {
		return new ProcessorCentrosBeneficio();
	}

	@Bean
	public ItemWriter<List<CentroBeneficioDTO>> interfazWritterCentrosBeneficio() {
		return new WriterCentrosBeneficio();
	}

	// MOntar Información CentroLog Por CentroBen
	@Bean
	public ItemReader<List<Object[]>> interfazReaderCentroLogPorCentroBen() {
		return new ReaderCentroLogPorCentroBen();
	}

	@Bean
	public ItemProcessor<List<Object[]>,  List<CentroLogCentroBenDTO>> interfazProcessorCentroLogPorCentroBen() {
		return new ProcessorCentroLogPorCentroBen();
	}

	@Bean
	public ItemWriter<List<CentroLogCentroBenDTO>> interfazWritterCentroLogPorCentroBen() {
		return new WriterCentroLogPorCentroBen();
	}

	// MOntar Información Unidad Negocios
	@Bean
	public ItemReader<List<Object[]>> interfazReaderUnidadNegocios() {
		return new ReaderUnidadNegocios();
	}

	@Bean
	public ItemProcessor<List<Object[]>, List<UnidadNegocioDTO>> interfazProcessorUnidadNegocios() {
		return new ProcessorUnidadNegocios();
	}

	@Bean
	public ItemWriter<List<UnidadNegocioDTO>> interfazWritterUnidadNegocios() {
		return new WriterUnidadNegocios();
	}

	// MOntar Información Unidad Neg Por Centro Log
	@Bean
	public ItemReader<List<Object[]>> interfazReaderConfiguracionPresupuestoServicio() {
		return new ReaderConfiguracionPresupuestoServicio();
	}

	@Bean
	public ItemProcessor<List<Object[]>, List<ConfiguracionPresupuestoServicioDTO>> interfazProcessorConfiguracionPresupuestoServicio() {
		return new ProcessorConfiguracionPresupuestoServicio();
	}

	@Bean
	public ItemWriter<List<ConfiguracionPresupuestoServicioDTO>> interfazWritterConfiguracionPresupuestoServicio() {
		return new WriterConfiguracionPresupuestoServicio();
	}

	// MOntar Información Tabla 15
	@Bean
	public ItemReader<List<Object[]>> interfazReaderTabla15() {
		return new ReaderTabla15();
	}

	@Bean
	public ItemProcessor<List<Object[]>,List<Tabla15DTO>> interfazProcessorTabla15() {
		return new ProcessorTabla15();
	}

	@Bean
	public ItemWriter<List<Tabla15DTO>> interfazWritterTabla15() {
		return new WriterTabla15();
	}
	
	// MOntar Información Servicios
	@Bean
	public ItemReader<List<Object[]>> interfazReaderServicios() {
		return new ReaderServicios();
	}

	@Bean
	public ItemProcessor<List<Object[]>, List<ServicioDTO>> interfazProcessorServicios() {
		return new ProcessorServicios();
	}

	@Bean
	public ItemWriter<List<ServicioDTO>> interfazWritterServicios() {
		return new WriterServicios();
	}

	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}

}
