package com.zyg.test.date;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {/*
											 * int x=0x8; int y=0x8; x=x>>1;
											 * y=y>>>1;
											 * System.out.println("0x80000000>>1 =" +
											 * Integer.toBinaryString(x));
											 * System.out.println("0x80000000>>>1 =" +
											 * Integer.toBinaryString(y));
											 */
		Long modelNo= new Long(560);
		String areaNo="421001";
		String audienceNo="000000000000";
		String isrepeat="首播";
		String showType="自办栏目";
		String temp = "' and trim(showtype) = '自办栏目' and trim(isrepeat)='首播'" ;
		//orderby = "v."+orderby + ",v.channelno,v.begintime";
		
		/*StringBuffer sqlStr = new StringBuffer();
		
		sqlStr.append("select pgmname,channelname,min(begintime),max(endtime),avg(rtg) rtg,avg(shar) shar");
		sqlStr.append(" from(select  playdate,channelname,pgmname,begintime,endtime,rtg,shar,audienceno,showtype");
		sqlStr.append(" from v_programresult where playdate between (select min(playdate)");
		sqlStr.append(" from v_programresult where  modelno='");
		sqlStr.append(modelNo);
		
		sqlStr.append("') and (select max(playdate) from v_programresult where  modelno='");
		sqlStr.append(modelNo);
		sqlStr.append(")and modelno='");
		sqlStr.append(modelNo);
		sqlStr.append("' and AreaNo='");
		sqlStr.append(areaNo);
		sqlStr.append("' and AudienceNo='");
		sqlStr.append(audienceNo);
		sqlStr.append(temp);
		sqlStr.append(" and trim(pgmname) in(select trim(PROGRAMNAME) from JINGZHOUSELFPGM) order by playdate)  group by channelname,pgmname,audienceno,showtype  order by rtg desc,channelname");
		*/
		StringBuffer SqlStr = new StringBuffer(
		"select c.* from (select min(resultno) resultno ,min(modelno) modelno");	
		SqlStr.append(",min(pgmname) pgmname,min(channelno) channelno");
		SqlStr.append(",channelname ,substr(min(begintime),1,5) begintime");
		SqlStr.append(",avg(rtg) rtg,avg(shar) shar from v_programresult where modelno=");
		SqlStr.append(modelNo);
		SqlStr.append(" and audienceno='");
		SqlStr.append(audienceNo);
		
		SqlStr.append("' and showtype='自办栏目' and isrepeat='首播' and not REGEXP_LIKE(trim(pgmname), 'A版|B版') group by channelname,pgmname");
		SqlStr.append(" union all select min(resultno) resultno ,min(modelno) modelno");
		SqlStr.append(",substr(trim(pgmname),1,length(trim(pgmname))-2) pgmname");
		SqlStr.append(",min(channelno) channelno,channelname");
		SqlStr.append(",substr(min(begintime),1,5) begintime,avg(rtg) rtg,avg(shar) shar");
		
		SqlStr.append(" from v_programresult where modelno=");
		SqlStr.append(modelNo);
		SqlStr.append(" and audienceno='");
		SqlStr.append(audienceNo);
		
		SqlStr.append("' and showtype='自办栏目' and isrepeat='首播' and REGEXP_LIKE(trim(pgmname), 'A版|B版')");
		SqlStr.append(" group by channelname,substr(trim(pgmname),1,length(trim(pgmname))-2) ");
		SqlStr.append("  order by pgmname) c order by c.rtg desc");
		
		System.out.println(SqlStr.toString());
	}
}
