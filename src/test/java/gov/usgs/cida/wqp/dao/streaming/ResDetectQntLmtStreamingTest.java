package gov.usgs.cida.wqp.dao.streaming;

import static gov.usgs.cida.wqp.swagger.model.StationCountJson.BIODATA;
import static gov.usgs.cida.wqp.swagger.model.StationCountJson.NWIS;
import static gov.usgs.cida.wqp.swagger.model.StationCountJson.STEWARDS;
import static gov.usgs.cida.wqp.swagger.model.StationCountJson.STORET;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.LinkedList;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

import gov.usgs.cida.wqp.BaseSpringTest;
import gov.usgs.cida.wqp.CsvDataSetLoader;
import gov.usgs.cida.wqp.DBIntegrationTest;
import gov.usgs.cida.wqp.dao.NameSpace;
import gov.usgs.cida.wqp.dao.intfc.IStreamingDao;
import gov.usgs.cida.wqp.mapping.BaseColumn;
import gov.usgs.cida.wqp.mapping.ResultColumn;
import gov.usgs.cida.wqp.mapping.TestResDetectQntLmtMap;
import gov.usgs.cida.wqp.mapping.TestResultHandler;
import gov.usgs.cida.wqp.parameter.FilterParameters;

@Category(DBIntegrationTest.class)
@DatabaseSetup("classpath:/testData/csv/")
@DbUnitConfiguration(dataSetLoader = CsvDataSetLoader.class)
public class ResDetectQntLmtStreamingTest extends BaseSpringTest {
	private static final Logger LOG = LoggerFactory.getLogger(ActivityMetricStreamingTest.class);

	@Autowired 
	IStreamingDao streamingDao;

	TestResultHandler handler;
	FilterParameters filter;
	NameSpace nameSpace = NameSpace.RES_DETECT_QNT_LMT;

	public static final String[] STEWARDS_1 = new String[]{STEWARDS, "1"};
	public static final String[] STEWARDS_2 = new String[]{STEWARDS, "2"};
	public static final String[] STEWARDS_3 = new String[]{STEWARDS, "3"};
	public static final String[] STEWARDS_4 = new String[]{STEWARDS, "4"};
	public static final String[] STEWARDS_5 = new String[]{STEWARDS, "5"};
	public static final String[] STEWARDS_6 = new String[]{STEWARDS, "6"};
	public static final String[] STEWARDS_7 = new String[]{STEWARDS, "7"};
	public static final String[] STEWARDS_8 = new String[]{STEWARDS, "8"};
	public static final String[] STEWARDS_9 = new String[]{STEWARDS, "9"};
	public static final String[] NWIS_10 = new String[]{NWIS, "10"};
	public static final String[] NWIS_11 = new String[]{NWIS, "11"};
	public static final String[] NWIS_12 = new String[]{NWIS, "12"};
	public static final String[] NWIS_13 = new String[]{NWIS, "13"};
	public static final String[] NWIS_14 = new String[]{NWIS, "14"};
	public static final String[] NWIS_15 = new String[]{NWIS, "15"};
	public static final String[] NWIS_16 = new String[]{NWIS, "16"};
	public static final String[] STORET_17 = new String[]{STORET, "17"};
	public static final String[] STORET_18 = new String[]{STORET, "18"};
	public static final String[] STORET_19 = new String[]{STORET, "19"};
	public static final String[] STORET_20 = new String[]{STORET, "20"};
	public static final String[] STORET_21 = new String[]{STORET, "21"};
	public static final String[] STORET_22 = new String[]{STORET, "22"};
	public static final String[] STORET_23 = new String[]{STORET, "23"};
	public static final String[] STORET_24 = new String[]{STORET, "24"};
	public static final String[] STORET_25 = new String[]{STORET, "25"};
	public static final String[] STORET_26 = new String[]{STORET, "26"};
	public static final String[] STORET_27 = new String[]{STORET, "27"};
	public static final String[] STORET_28 = new String[]{STORET, "28"};
	public static final String[] STORET_29 = new String[]{STORET, "29"};
	public static final String[] STORET_30 = new String[]{STORET, "30"};
	public static final String[] STORET_31 = new String[]{STORET, "31"};
	public static final String[] STORET_32 = new String[]{STORET, "32"};
	public static final String[] STORET_33 = new String[]{STORET, "33"};
	public static final String[] STORET_34 = new String[]{STORET, "34"};
	public static final String[] STORET_35 = new String[]{STORET, "35"};
	public static final String[] STORET_36 = new String[]{STORET, "36"};
	public static final String[] STORET_37 = new String[]{STORET, "37"};
	public static final String[] STORET_38 = new String[]{STORET, "38"};
	public static final String[] STORET_39 = new String[]{STORET, "39"};
	public static final String[] STORET_40 = new String[]{STORET, "40"};
	public static final String[] STORET_41 = new String[]{STORET, "41"};
	public static final String[] STORET_42 = new String[]{STORET, "42"};
	public static final String[] STORET_43 = new String[]{STORET, "43"};
	public static final String[] STORET_44 = new String[]{STORET, "44"};
	public static final String[] STORET_45 = new String[]{STORET, "45"};
	public static final String[] STORET_46 = new String[]{STORET, "46"};
	public static final String[] STORET_47 = new String[]{STORET, "47"};
	public static final String[] STORET_48 = new String[]{STORET, "48"};
	public static final String[] STORET_49 = new String[]{STORET, "49"};
	public static final String[] STORET_50 = new String[]{STORET, "50"};
	public static final String[] STORET_51 = new String[]{STORET, "51"};
	public static final String[] STORET_52 = new String[]{STORET, "52"};
	public static final String[] STORET_53 = new String[]{STORET, "53"};
	public static final String[] STORET_54 = new String[]{STORET, "54"};
	public static final String[] STORET_55 = new String[]{STORET, "55"};
	public static final String[] STORET_56 = new String[]{STORET, "56"};
	public static final String[] STORET_57 = new String[]{STORET, "57"};
	public static final String[] STORET_58 = new String[]{STORET, "58"};
	public static final String[] STORET_59 = new String[]{STORET, "59"};
	public static final String[] STORET_60 = new String[]{STORET, "60"};
	public static final String[] STORET_61 = new String[]{STORET, "61"};
	public static final String[] STORET_62 = new String[]{STORET, "62"};
	public static final String[] STORET_63 = new String[]{STORET, "63"};
	public static final String[] STORET_64 = new String[]{STORET, "64"};
	public static final String[] STORET_65 = new String[]{STORET, "65"};
	public static final String[] STORET_66 = new String[]{STORET, "66"};
	public static final String[] STORET_67 = new String[]{STORET, "67"};
	public static final String[] STORET_68 = new String[]{STORET, "68"};
	public static final String[] STORET_69 = new String[]{STORET, "69"};
	public static final String[] STORET_70 = new String[]{STORET, "70"};
	public static final String[] STORET_71 = new String[]{STORET, "71"};
	public static final String[] STORET_72 = new String[]{STORET, "72"};
	public static final String[] STORET_73 = new String[]{STORET, "73"};
	public static final String[] BIODATA_74 = new String[]{BIODATA, "74"};

	public static final int RES_DETECT_QNT_LMT_COLUMN_COUNT = TestResDetectQntLmtMap.RES_DETECT_QNT_LMT.keySet().size();

	@Before
	public void init() {
		handler = new TestResultHandler();
		filter = new FilterParameters();
	}

	@After
	public void cleanup() {
		handler = null;
		filter = null;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Only need Activity (and possibly a lookup table)

	@Test
	public void nullParameterTest() {
		streamingDao.stream(nameSpace, null, handler);
		assertEquals(TOTAL_RES_DETECT_QNT_LMT_COUNT, String.valueOf(handler.getResults().size()));
	}

	@Test
	public void emptyParameterTest() {
		streamingDao.stream(nameSpace, filter, handler);
		assertEquals(TOTAL_RES_DETECT_QNT_LMT_COUNT, String.valueOf(handler.getResults().size()));
	}

	@Test
	public void allDataSortedTest() {
		filter.setSorted("yes");
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		//Validate the number AND order of results.
		assertEquals(TOTAL_RES_DETECT_QNT_LMT_COUNT, String.valueOf(results.size()));
		assertStewards("1", results.get(0));
		assertStewards("2", results.get(1));
		assertStewards("5", results.get(2));
		assertStewards("3", results.get(3));
		assertStewards("4", results.get(4));
		assertStewards("8", results.get(5));
		assertStewards("9", results.get(6));
		assertStewards("6", results.get(7));
		assertStewards("7", results.get(8));
		assertNwis("10", results.get(9));
		assertNwis("11", results.get(10));
		assertNwis("12", results.get(11));
		assertNwis("13", results.get(12));
		assertNwis("14", results.get(13));
		assertNwis("15", results.get(14));
		assertNwis("16", results.get(15));
		assertStoret("56", results.get(16));
		assertStoret("40", results.get(17));
		assertStoret("41", results.get(18));
		assertStoret("42", results.get(19));
		assertStoret("47", results.get(20));
		assertStoret("46", results.get(21));
		assertStoret("43", results.get(22));
		assertStoret("44", results.get(23));
		assertStoret("45", results.get(24));
		assertStoret("48", results.get(25));
		assertStoret("49", results.get(26));
		assertStoret("50", results.get(27));
		assertStoret("51", results.get(28));
		assertStoret("52", results.get(29));
		assertStoret("53", results.get(30));
		assertStoret("54", results.get(31));
		assertStoret("55", results.get(32));
		assertStoret("57", results.get(33));
		assertStoret("58", results.get(34));
		assertStoret("59", results.get(35));
		assertStoret("60", results.get(36));
		assertStoret("62", results.get(37));
		assertStoret("63", results.get(38));
		assertStoret("67", results.get(39));
		assertStoret("68", results.get(40));
		assertStoret("64", results.get(41));
		assertStoret("66", results.get(42));
		assertStoret("69", results.get(43));
		assertStoret("61", results.get(44));
		assertStoret("65", results.get(45));
		assertStoret39(results.get(46));
		assertStoret("29", results.get(47));
		assertStoret("30", results.get(48));
		assertStoret("31", results.get(49));
		assertStoret("38", results.get(50));
		assertStoret("32", results.get(51));
		assertStoret("33", results.get(52));
		assertStoret("34", results.get(53));
		assertStoret("35", results.get(54));
		assertStoret("36", results.get(55));
		assertStoret("37", results.get(56));
		assertStoret("72", results.get(57));
		assertStoret("73", results.get(58));
		assertStoret("70", results.get(59));
		assertStoret("71", results.get(60));
		assertStoret("24", results.get(61));
		assertStoret("25", results.get(62));
		assertStoret("26", results.get(63));
		assertStoret("27", results.get(64));
		assertStoret("17", results.get(65));
		assertStoret("18", results.get(66));
		assertStoret("19", results.get(67));
		assertStoret("23", results.get(68));
		assertStoret("22", results.get(69));
		assertStoret("20", results.get(70));
		assertStoret("21", results.get(71));
		assertStoret("28", results.get(72));
		assertBiodata("74", results.get(73));
	}

	@Test
	public void analyticalMethodTest() {
		filter.setAnalyticalmethod(getAnalyticalMethod());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(22, results.size());
		assertContainsResDetectQntLmt(results,
				NWIS_10, NWIS_11, NWIS_12, NWIS_13, NWIS_14, NWIS_15, STORET_17, STORET_18, STORET_19, STORET_20,
				STORET_21, STORET_22, STORET_23, STORET_24, STORET_25, STORET_26, STORET_27, STORET_28, STORET_70, STORET_71, 
				STORET_72, STORET_73);
	}

	@Test
	public void assemblageTest() {
		filter.setAssemblage(getAssemblage());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(17, results.size());
		assertContainsResDetectQntLmt(results,
				STORET_17, STORET_18, STORET_19, STORET_20, STORET_21, STORET_22, STORET_23, STORET_24, STORET_25, STORET_26,
				STORET_27, STORET_28, STORET_70, STORET_71, STORET_72, STORET_73, BIODATA_74);
	}

	@Test
	public void avoidTest() {
		filter.setCommand(getCommand());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(STORET_RES_DETECT_QNT_LMT_COUNT, String.valueOf(results.size()));
		assertContainsResDetectQntLmt(results,
				STORET_17, STORET_18, STORET_19, STORET_20, STORET_21, STORET_22, STORET_23, STORET_24, STORET_25, STORET_26,
				STORET_27, STORET_28, STORET_29, STORET_30, STORET_31, STORET_32, STORET_33, STORET_34, STORET_35, STORET_36,
				STORET_37, STORET_38, STORET_39, STORET_40, STORET_41, STORET_42, STORET_43, STORET_44, STORET_45, STORET_46,
				STORET_47, STORET_48, STORET_49, STORET_50, STORET_51, STORET_52, STORET_53, STORET_54, STORET_55, STORET_56,
				STORET_57, STORET_58, STORET_59, STORET_60, STORET_61, STORET_62, STORET_63, STORET_64, STORET_65, STORET_66,
				STORET_67, STORET_68, STORET_69, STORET_70, STORET_71, STORET_72, STORET_73);
	}

	@Test
	public void bboxTest() {
		filter.setBBox(getBBox());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(42, results.size());
		assertContainsResDetectQntLmt(results,
				STEWARDS_1, STEWARDS_2, STEWARDS_3, STEWARDS_4, STEWARDS_5, STEWARDS_6, STEWARDS_7, STEWARDS_8, STEWARDS_9, NWIS_10,
				NWIS_11, NWIS_12, NWIS_13, NWIS_14, NWIS_15, NWIS_16, STORET_17, STORET_18, STORET_19, STORET_20,
				STORET_21, STORET_22, STORET_23, STORET_24, STORET_25, STORET_26, STORET_27, STORET_29, STORET_30, STORET_31,
				STORET_32, STORET_33, STORET_34, STORET_35, STORET_36, STORET_37, STORET_38, STORET_39, STORET_70, STORET_71,
				STORET_72, STORET_73);
	}

	@Test
	public void characteristicNameTest() {
		filter.setCharacteristicName(getCharacteristicName());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(16, results.size());
		assertContainsResDetectQntLmt(results,
				STORET_17, STORET_18, STORET_19, STORET_20, STORET_21, STORET_22, STORET_23, STORET_24, STORET_25, STORET_26,
				STORET_27, STORET_28, STORET_70, STORET_71, STORET_72, STORET_73);
	}

	@Test
	public void characteristicTypeTest() {
		filter.setCharacteristicType(getCharacteristicType());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(21, results.size());
		assertContainsResDetectQntLmt(results,
				STEWARDS_1, STEWARDS_2, STEWARDS_3, STEWARDS_4, STEWARDS_5, STORET_17, STORET_18, STORET_19, STORET_20, STORET_21,
				STORET_22, STORET_23, STORET_24, STORET_25, STORET_26, STORET_27, STORET_28, STORET_70, STORET_71, STORET_72,
				STORET_73);
	}

	@Test
	public void countryTest() {
		filter.setCountrycode(getCountry());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(44, results.size());
		assertContainsResDetectQntLmt(results,
				STEWARDS_1, STEWARDS_2, STEWARDS_3, STEWARDS_4, STEWARDS_5, STEWARDS_6, STEWARDS_7, STEWARDS_8, STEWARDS_9, NWIS_10,
				NWIS_11, NWIS_12, NWIS_13, NWIS_14, NWIS_15, NWIS_16, STORET_17, STORET_18, STORET_19, STORET_20,
				STORET_21, STORET_22, STORET_23, STORET_24, STORET_25, STORET_26, STORET_27, STORET_28, STORET_29, STORET_30,
				STORET_31, STORET_32, STORET_33, STORET_34, STORET_35, STORET_36, STORET_37, STORET_38, STORET_39, STORET_70,
				STORET_71, STORET_72, STORET_73, BIODATA_74);
	}

	@Test
	public void countyTest() {
		filter.setCountycode(getCounty());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(43, results.size());
		assertContainsResDetectQntLmt(results,
				STEWARDS_1, STEWARDS_2, STEWARDS_3, STEWARDS_4, STEWARDS_5, STEWARDS_6, STEWARDS_7, STEWARDS_8, STEWARDS_9, NWIS_10,
				NWIS_11, NWIS_12, NWIS_13, NWIS_14, NWIS_15, NWIS_16, STORET_17, STORET_18, STORET_19, STORET_20,
				STORET_21, STORET_22, STORET_23, STORET_24, STORET_25, STORET_26, STORET_27, STORET_28, STORET_29, STORET_30,
				STORET_31, STORET_32, STORET_33, STORET_34, STORET_35, STORET_36, STORET_37, STORET_38, STORET_39, STORET_70,
				STORET_71, STORET_72, STORET_73);
	}

	@Test
	public void huc2Test() {
		filter.setHuc(getHuc2());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(31, results.size());
		assertContainsResDetectQntLmt(results,
				STEWARDS_1, STEWARDS_2, STEWARDS_3, STEWARDS_4, STEWARDS_5, STEWARDS_6, STEWARDS_7, STEWARDS_8, STEWARDS_9, NWIS_10,
				NWIS_11, NWIS_12, NWIS_13, NWIS_14, NWIS_15, NWIS_16, STORET_29, STORET_30, STORET_31, STORET_32,
				STORET_33, STORET_34, STORET_35, STORET_36, STORET_37, STORET_38, STORET_39, STORET_70, STORET_71, STORET_72,
				STORET_73);
	}

	@Test
	public void huc4Test() {
		filter.setHuc(getHuc4());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(18, results.size());
		assertContainsResDetectQntLmt(results,
				NWIS_10, NWIS_11, NWIS_12, NWIS_13, NWIS_14, NWIS_15, NWIS_16, STORET_29, STORET_30, STORET_31,
				STORET_32, STORET_33, STORET_34, STORET_35, STORET_36, STORET_37, STORET_38, STORET_39);
	}

	@Test
	public void huc6Test() {
		filter.setHuc(getHuc6());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(17, results.size());
		assertContainsResDetectQntLmt(results,
				NWIS_10, NWIS_11, NWIS_12, NWIS_13, NWIS_14, NWIS_15, STORET_29, STORET_30, STORET_31, STORET_32,
				STORET_33, STORET_34, STORET_35, STORET_36, STORET_37, STORET_38, STORET_39);
	}

	@Test
	public void huc8Test() {
		filter.setHuc(getHuc8());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(11, results.size());
		assertContainsResDetectQntLmt(results,
				STORET_29, STORET_30, STORET_31, STORET_32, STORET_33, STORET_34, STORET_35, STORET_36, STORET_37, STORET_38,
				STORET_39);
	}

	@Test
	public void manySitesTest() {
		try {
			filter.setSiteid(getManySiteId());
			streamingDao.stream(nameSpace, filter, handler);
		} catch (Exception e) {
			fail(e.getLocalizedMessage());
		}

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(22, results.size());
		assertContainsResDetectQntLmt(results,
				STORET_17, STORET_18, STORET_19, STORET_20, STORET_21, STORET_22, STORET_23, STORET_24, STORET_25, STORET_26,
				STORET_27, STORET_29, STORET_30, STORET_31, STORET_32, STORET_33, STORET_34, STORET_35, STORET_36, STORET_37,
				STORET_38, STORET_39);
	}

	@Test
	public void minActivitiesTest() {
		filter.setMinactivities(getMinActivities());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(67, results.size());
		assertContainsResDetectQntLmt(results,
				STEWARDS_1, STEWARDS_2, STEWARDS_3, STEWARDS_4, STEWARDS_5, NWIS_10, NWIS_11, NWIS_12, NWIS_13, NWIS_14,
				NWIS_15, STORET_17, STORET_18, STORET_19, STORET_20, STORET_21, STORET_22, STORET_23, STORET_24, STORET_25,
				STORET_26, STORET_27, STORET_29, STORET_30, STORET_31, STORET_32, STORET_33, STORET_34, STORET_35, STORET_36,
				STORET_37, STORET_38, STORET_39, STORET_40, STORET_41, STORET_42, STORET_43, STORET_44, STORET_45, STORET_46,
				STORET_47, STORET_48, STORET_49, STORET_50, STORET_51, STORET_52, STORET_53, STORET_54, STORET_55, STORET_56,
				STORET_57, STORET_58, STORET_59, STORET_60, STORET_61, STORET_62, STORET_63, STORET_64, STORET_65, STORET_66,
				STORET_67, STORET_68, STORET_69, STORET_70, STORET_71, STORET_72, STORET_73);
	}

	@Test
	public void minResultsTest() {
		filter.setMinresults(getMinResults());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(62, results.size());
		assertContainsResDetectQntLmt(results,
				NWIS_10, NWIS_11, NWIS_12, NWIS_13, NWIS_14, NWIS_15, STORET_17, STORET_18, STORET_19, STORET_20,
				STORET_21, STORET_22, STORET_23, STORET_24, STORET_25, STORET_26, STORET_27, STORET_29, STORET_30, STORET_31,
				STORET_32, STORET_33, STORET_34, STORET_35, STORET_36, STORET_37, STORET_38, STORET_39, STORET_40, STORET_41,
				STORET_42, STORET_43, STORET_44, STORET_45, STORET_46, STORET_47, STORET_48, STORET_49, STORET_50, STORET_51,
				STORET_52, STORET_53, STORET_54, STORET_55, STORET_56, STORET_57, STORET_58, STORET_59, STORET_60, STORET_61,
				STORET_62, STORET_63, STORET_64, STORET_65, STORET_66, STORET_67, STORET_68, STORET_69, STORET_70, STORET_71,
				STORET_72, STORET_73);
	}

	@Test
	public void nldiUrlTest() {
		try {
			filter.setNldiSites(getManySiteId());
			streamingDao.stream(nameSpace, filter, handler);
		} catch (Exception e) {
			fail(e.getLocalizedMessage());
		}

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(22, results.size());
		assertContainsResDetectQntLmt(results,
				STORET_17, STORET_18, STORET_19, STORET_20, STORET_21, STORET_22, STORET_23, STORET_24, STORET_25, STORET_26,
				STORET_27, STORET_29, STORET_30, STORET_31, STORET_32, STORET_33, STORET_34, STORET_35, STORET_36, STORET_37,
				STORET_38, STORET_39);
	}

	@Test
	public void organizationTest() {
		filter.setOrganization(getOrganization());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(43, results.size());
		assertContainsResDetectQntLmt(results,
				STEWARDS_1, STEWARDS_2, STEWARDS_3, STEWARDS_4, STEWARDS_5, STEWARDS_6, STEWARDS_7, STEWARDS_8, STEWARDS_9, NWIS_10,
				NWIS_11, NWIS_12, NWIS_13, NWIS_14, NWIS_15, NWIS_16, STORET_17, STORET_18, STORET_19, STORET_20,
				STORET_21, STORET_22, STORET_23, STORET_24, STORET_25, STORET_26, STORET_27, STORET_28, STORET_29, STORET_30,
				STORET_31, STORET_32, STORET_33, STORET_34, STORET_35, STORET_36, STORET_37, STORET_38, STORET_39, STORET_70,
				STORET_71, STORET_72, STORET_73);
	}

	@Test
	public void pcodeTest() {
		filter.setPCode(getPcode());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(16, results.size());
		assertContainsResDetectQntLmt(results,
				NWIS_16, STORET_17, STORET_18, STORET_19, STORET_20, STORET_21, STORET_22, STORET_23, STORET_24, STORET_25,
				STORET_26, STORET_27, STORET_70, STORET_71, STORET_72, STORET_73);
	}

	@Test
	public void projectTest() {
		filter.setProject(getProject());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(28, results.size());
		assertContainsResDetectQntLmt(results,
				STEWARDS_1, STEWARDS_2, STEWARDS_6, STEWARDS_7, STEWARDS_8, STEWARDS_9, NWIS_10, NWIS_11, NWIS_12, NWIS_13,
				NWIS_14, NWIS_16, STORET_17, STORET_18, STORET_19, STORET_20, STORET_21, STORET_22, STORET_23, STORET_24,
				STORET_25, STORET_26, STORET_27, STORET_28, STORET_70, STORET_72, STORET_73, BIODATA_74);
	}

	@Test
	public void providersTest() {
		filter.setProviders(getProviders());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(73, results.size());
		assertContainsResDetectQntLmt(results,
				STEWARDS_1, STEWARDS_2, STEWARDS_3, STEWARDS_4, STEWARDS_5, STEWARDS_6, STEWARDS_7, STEWARDS_8, STEWARDS_9, NWIS_10,
				NWIS_11, NWIS_12, NWIS_13, NWIS_14, NWIS_15, NWIS_16, STORET_17, STORET_18, STORET_19, STORET_20,
				STORET_21, STORET_22, STORET_23, STORET_24, STORET_25, STORET_26, STORET_27, STORET_28, STORET_29, STORET_30,
				STORET_31, STORET_32, STORET_33, STORET_34, STORET_35, STORET_36, STORET_37, STORET_38, STORET_39, STORET_40,
				STORET_41, STORET_42, STORET_43, STORET_44, STORET_45, STORET_46, STORET_47, STORET_48, STORET_49, STORET_50,
				STORET_51, STORET_52, STORET_53, STORET_54, STORET_55, STORET_56, STORET_57, STORET_58, STORET_59, STORET_60,
				STORET_61, STORET_62, STORET_63, STORET_64, STORET_65, STORET_66, STORET_67, STORET_68, STORET_69, STORET_70,
				STORET_71, STORET_72, STORET_73);
	}

	@Test
	public void resultTest() {
		filter.setResult(getResult());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(1, results.size());
		assertContainsResDetectQntLmt(results,
				STORET_39);
	}

	@Test
	public void sampleMediaTest() {
		filter.setSampleMedia(getSampleMedia());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(70, results.size());
		assertContainsResDetectQntLmt(results,
				STEWARDS_1, STEWARDS_2, STEWARDS_6, STEWARDS_7, STEWARDS_8, STEWARDS_9, NWIS_10, NWIS_11, NWIS_12, NWIS_13,
				NWIS_14, NWIS_16, STORET_17, STORET_18, STORET_19, STORET_20, STORET_21, STORET_22, STORET_23, STORET_24,
				STORET_25, STORET_26, STORET_27, STORET_28, STORET_29, STORET_30, STORET_31, STORET_32, STORET_33, STORET_34,
				STORET_35, STORET_36, STORET_37, STORET_38, STORET_39, STORET_40, STORET_41, STORET_42, STORET_43, STORET_44,
				STORET_45, STORET_46, STORET_47, STORET_48, STORET_49, STORET_50, STORET_51, STORET_52, STORET_53, STORET_54,
				STORET_55, STORET_56, STORET_57, STORET_58, STORET_59, STORET_60, STORET_61, STORET_62, STORET_63, STORET_64,
				STORET_65, STORET_66, STORET_67, STORET_68, STORET_69, STORET_70, STORET_71, STORET_72, STORET_73, BIODATA_74);
	}

	@Test
	public void siteIdTest() {
		filter.setSiteid(getSiteid());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(32, results.size());
		assertContainsResDetectQntLmt(results,
				STEWARDS_1, STEWARDS_2, STEWARDS_3, STEWARDS_4, STEWARDS_5, STEWARDS_6, STEWARDS_7, STEWARDS_8, STEWARDS_9, NWIS_10,
				NWIS_11, NWIS_12, NWIS_13, NWIS_14, NWIS_15, NWIS_16, STORET_17, STORET_18, STORET_19, STORET_20,
				STORET_21, STORET_22, STORET_23, STORET_24, STORET_25, STORET_26, STORET_27, STORET_28, STORET_70, STORET_71,
				STORET_72, STORET_73);
	}


	@Test
	public void siteTypeTest() {
		filter.setSiteType(getSiteType());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(73, results.size());
		assertContainsResDetectQntLmt(results,
				STEWARDS_1, STEWARDS_2, STEWARDS_3, STEWARDS_4, STEWARDS_5, STEWARDS_6, STEWARDS_7, STEWARDS_8, STEWARDS_9, NWIS_10,
				NWIS_11, NWIS_12, NWIS_13, NWIS_14, NWIS_15, STORET_17, STORET_18, STORET_19, STORET_20, STORET_21,
				STORET_22, STORET_23, STORET_24, STORET_25, STORET_26, STORET_27, STORET_28, STORET_29, STORET_30, STORET_31,
				STORET_32, STORET_33, STORET_34, STORET_35, STORET_36, STORET_37, STORET_38, STORET_39, STORET_40, STORET_41,
				STORET_42, STORET_43, STORET_44, STORET_45, STORET_46, STORET_47, STORET_48, STORET_49, STORET_50, STORET_51,
				STORET_52, STORET_53, STORET_54, STORET_55, STORET_56, STORET_57, STORET_58, STORET_59, STORET_60, STORET_61,
				STORET_62, STORET_63, STORET_64, STORET_65, STORET_66, STORET_67, STORET_68, STORET_69, STORET_70, STORET_71,
				STORET_72, STORET_73, BIODATA_74);
	}

	@Test
	public void startDateHiTest() {
		filter.setStartDateHi(getStartDateHi());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(70, results.size());
		assertContainsResDetectQntLmt(results,
				STEWARDS_1, STEWARDS_2, STEWARDS_6, STEWARDS_7, STEWARDS_8, STEWARDS_9, NWIS_10, NWIS_11, NWIS_12, NWIS_13,
				NWIS_14, NWIS_16, STORET_17, STORET_18, STORET_19, STORET_20, STORET_21, STORET_22, STORET_23, STORET_24,
				STORET_25, STORET_26, STORET_27, STORET_28, STORET_29, STORET_30, STORET_31, STORET_32, STORET_33, STORET_34,
				STORET_35, STORET_36, STORET_37, STORET_38, STORET_39, STORET_40, STORET_41, STORET_42, STORET_43, STORET_44,
				STORET_45, STORET_46, STORET_47, STORET_48, STORET_49, STORET_50, STORET_51, STORET_52, STORET_53, STORET_54,
				STORET_55, STORET_56, STORET_57, STORET_58, STORET_59, STORET_60, STORET_61, STORET_62, STORET_63, STORET_64,
				STORET_65, STORET_66, STORET_67, STORET_68, STORET_69, STORET_70, STORET_71, STORET_72, STORET_73, BIODATA_74);
	}

	@Test
	public void startDateLoTest() {
		filter.setStartDateLo(getStartDateLo());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(33, results.size());
		assertContainsResDetectQntLmt(results,
				STEWARDS_1, STEWARDS_2, STEWARDS_3, STEWARDS_4, STEWARDS_5, STEWARDS_6, STEWARDS_7, STEWARDS_8, STEWARDS_9, NWIS_10,
				NWIS_11, NWIS_12, NWIS_13, NWIS_14, NWIS_15, NWIS_16, STORET_17, STORET_18, STORET_19, STORET_20,
				STORET_21, STORET_22, STORET_23, STORET_24, STORET_25, STORET_26, STORET_27, STORET_28, STORET_70, STORET_71,
				STORET_72, STORET_73, BIODATA_74);
	}

	@Test
	public void stateTest() {
		filter.setStatecode(getState());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(43, results.size());
		assertContainsResDetectQntLmt(results,
				STEWARDS_1, STEWARDS_2, STEWARDS_3, STEWARDS_4, STEWARDS_5, STEWARDS_6, STEWARDS_7, STEWARDS_8, STEWARDS_9, NWIS_10,
				NWIS_11, NWIS_12, NWIS_13, NWIS_14, NWIS_15, NWIS_16, STORET_17, STORET_18, STORET_19, STORET_20,
				STORET_21, STORET_22, STORET_23, STORET_24, STORET_25, STORET_26, STORET_27, STORET_28, STORET_29, STORET_30,
				STORET_31, STORET_32, STORET_33, STORET_34, STORET_35, STORET_36, STORET_37, STORET_38, STORET_39, STORET_70,
				STORET_71, STORET_72, STORET_73);
	}

	@Test
	public void subjectTaxonomicNameTest() {
		filter.setSubjectTaxonomicName(getSubjectTaxonomicName());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(16, results.size());
		assertContainsResDetectQntLmt(results,
				STORET_17, STORET_18, STORET_19, STORET_20, STORET_21, STORET_22, STORET_23, STORET_24, STORET_25, STORET_26,
				STORET_27, STORET_28, STORET_70, STORET_72, STORET_73, BIODATA_74);
	}

	@Test
	public void withinTest() {
		filter.setWithin(getWithin());
		filter.setLat(getLatitude());
		filter.setLong(getLongitude());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(69, results.size());
		assertContainsResDetectQntLmt(results,
				STEWARDS_1, STEWARDS_2, STEWARDS_3, STEWARDS_4, STEWARDS_5, STEWARDS_6, STEWARDS_7, STEWARDS_8, STEWARDS_9, NWIS_10,
				NWIS_11, NWIS_12, NWIS_13, NWIS_14, NWIS_15, NWIS_16, STORET_17, STORET_18, STORET_19, STORET_20,
				STORET_21, STORET_22, STORET_23, STORET_24, STORET_25, STORET_26, STORET_27, STORET_28, STORET_29, STORET_30,
				STORET_31, STORET_32, STORET_33, STORET_34, STORET_35, STORET_36, STORET_37, STORET_38, STORET_39, STORET_40,
				STORET_41, STORET_42, STORET_43, STORET_44, STORET_45, STORET_46, STORET_47, STORET_48, STORET_49, STORET_50,
				STORET_51, STORET_52, STORET_53, STORET_54, STORET_55, STORET_56, STORET_57, STORET_58, STORET_59, STORET_60,
				STORET_61, STORET_62, STORET_63, STORET_64, STORET_65, STORET_66, STORET_67, STORET_68, STORET_69);
	}

	@Test
	public void multipleParameterTests() {
		filter.setAnalyticalmethod(getAnalyticalMethod());
		filter.setAssemblage(getAssemblage());
		filter.setCommand(getCommand());
		filter.setCharacteristicName(getCharacteristicName());
		filter.setCharacteristicType(getCharacteristicType());
		filter.setCountrycode(getCountry());
		filter.setCountycode(getCounty());
		filter.setHuc(getHuc());
		filter.setMinactivities(getMinActivities());
		filter.setMinresults(getMinResults());
		filter.setNldiSites(getNldiSites());
		filter.setOrganization(getOrganization());
		filter.setPCode(getPcode());
		filter.setProject(getProject());
		filter.setProviders(getProviders());
		filter.setSampleMedia(getSampleMedia());
		filter.setSiteid(getSiteid());
		filter.setSiteType(getSiteType());
		filter.setStartDateHi(getStartDateHi());
		filter.setStartDateLo(getStartDateLo());
		filter.setStatecode(getState());
		filter.setSubjectTaxonomicName(getSubjectTaxonomicName());
		streamingDao.stream(nameSpace, filter, handler);

		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(10, results.size());
		assertContainsResDetectQntLmt(results,
				STORET_17, STORET_18, STORET_19, STORET_20, STORET_21, STORET_22, STORET_23, STORET_70, STORET_72, STORET_73);
	}

	@Test
	public void multipleParameterWithStationSumTests() {
		filter.setAnalyticalmethod(getAnalyticalMethod());
		filter.setAssemblage(getAssemblage());
		filter.setCommand(getCommand());
		filter.setBBox(getBBox());
		filter.setCharacteristicName(getCharacteristicName());
		filter.setCharacteristicType(getCharacteristicType());
		filter.setCountrycode(getCountry());
		filter.setCountycode(getCounty());
		filter.setHuc(getHuc());
		filter.setLat(getLatitude());
		filter.setLong(getLongitude());
		filter.setMinactivities(getMinActivities());
		filter.setMinresults(getMinResults());
		filter.setNldiSites(getNldiSites());
		filter.setOrganization(getOrganization());
		filter.setPCode(getPcode());
		filter.setProject(getProject());
		filter.setProviders(getProviders());
		filter.setSampleMedia(getSampleMedia());
		filter.setSiteid(getSiteid());
		filter.setSiteType(getSiteType());
		filter.setStartDateHi(getStartDateHi());
		filter.setStartDateLo(getStartDateLo());
		filter.setStatecode(getState());
		filter.setSubjectTaxonomicName(getSubjectTaxonomicName());
		filter.setWithin(getWithin());
		streamingDao.stream(nameSpace, filter, handler);
		LinkedList<Map<String, Object>> results = handler.getResults();
		assertEquals(7, results.size());
		assertContainsResDetectQntLmt(results,
				STORET_17, STORET_18, STORET_19, STORET_20, STORET_21, STORET_22, STORET_23);
	}

	public static void assertStewards(String detectionLimit, Map<String, Object> row) {
		assertEquals(RES_DETECT_QNT_LMT_COLUMN_COUNT, row.keySet().size());
		assertEquals(STEWARDS, row.get(BaseColumn.KEY_DATA_SOURCE));
		assertEquals(detectionLimit, row.get(ResultColumn.KEY_DETECTION_LIMIT));
	}

	public static void assertNwis(String detectionLimit, Map<String, Object> row) {
		assertEquals(RES_DETECT_QNT_LMT_COLUMN_COUNT, row.keySet().size());
		assertEquals(NWIS, row.get(BaseColumn.KEY_DATA_SOURCE));
		assertEquals(detectionLimit, row.get(ResultColumn.KEY_DETECTION_LIMIT));
	}

	public static void assertStoret(String detectionLimit, Map<String, Object> row) {
		assertEquals(RES_DETECT_QNT_LMT_COLUMN_COUNT, row.keySet().size());
		assertEquals(STORET, row.get(BaseColumn.KEY_DATA_SOURCE));
		assertEquals(detectionLimit, row.get(ResultColumn.KEY_DETECTION_LIMIT));
	}

	public static void assertBiodata(String detectionLimit, Map<String, Object> row) {
		assertEquals(RES_DETECT_QNT_LMT_COLUMN_COUNT, row.keySet().size());
		assertEquals(BIODATA, row.get(BaseColumn.KEY_DATA_SOURCE));
		assertEquals(detectionLimit, row.get(ResultColumn.KEY_DETECTION_LIMIT));
	}

	public void assertStoret39(Map<String, Object> row) {
		assertMapIsAsExpected(TestResDetectQntLmtMap.RES_DETECT_QNT_LMT, row);
	}

	public void assertContainsResDetectQntLmt(LinkedList<Map<String, Object>> results, String[]...  resDetectQntLmt) {
		for (Map<String, Object> result : results) {
			LOG.debug(BaseColumn.KEY_DATA_SOURCE + ":" + result.get(BaseColumn.KEY_DATA_SOURCE) + "/" 
						+ ResultColumn.KEY_DETECTION_LIMIT + ":" +  result.get(ResultColumn.KEY_DETECTION_LIMIT));
		}

		for (String[] i : resDetectQntLmt) {
			boolean isFound = false;
			for (Map<String, Object> result : results) {
				if (result.containsKey(BaseColumn.KEY_DATA_SOURCE)
						&& i[0].equalsIgnoreCase(((String) result.get(BaseColumn.KEY_DATA_SOURCE)))
						&& i[1].equalsIgnoreCase(result.get(ResultColumn.KEY_DETECTION_LIMIT).toString())) {
					isFound = true;
					break;
				}
			}
			if (!isFound) {
				fail(BaseColumn.KEY_DATA_SOURCE + ":" + i[0] + "/" + ResultColumn.KEY_DETECTION_LIMIT + ":" + i[1] + " was not in the result set.");
			}
		}
		assertEquals("Double check expected size", results.size(), resDetectQntLmt.length);
	}

}
