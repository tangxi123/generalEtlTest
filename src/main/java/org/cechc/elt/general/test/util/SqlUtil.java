package org.cechc.elt.general.test.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqlUtil {
    public static List<String> parseSqlToFields(String sql){
        List<String> fields = new ArrayList<>();
        String regex = "^select.*?from";
        Pattern pattern = Pattern.compile(regex,Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(sql.trim());
        while(matcher.find()){
            String group = matcher.group();
            System.out.println(group);
            String substring = group.substring("SELECT".length(), group.length()-"FROM".length());
            System.out.println(substring);
            String[] splits = substring.split(",");
            for(String split : splits){
               if(split.trim().contains("\\sas\\s")){
                   String as = split.split("as")[2];
                   fields.add(as);
               }if(split.trim().contains("\\sAs\\s")){
                    String as = split.split("AS")[2];
                    fields.add(as);

                }else{
                fields.add(split.trim());
               }
            }

        }
//        String[] splits = sql.trim().split(",");
//        for(String split:splits){
//            String trim = split.trim();
//            System.out.println(trim);
//        }
        return fields;
    }

    public static void main(String[] args) {
        String sql = "select case_base_info.org_code   as src_id,\n" +
                "       case_base_info.patient_id as record_id,\n" +
                "       0                         as delete_flag,\n" +
                "       0                         as test_record_flag,\n" +
                "       'N/A'                     as pcp_prov_id,\n" +
                "       '病人ID'                   as record_id_qualifier,\n" +
                "       id_card_no                as id_1,\n" +
                "       '身份证号码'                   as id_1_qualifier,\n" +
                "       medical_safety_no         as id_2,\n" +
                "       '医疗保险号'                   as id_2_qualifier,\n" +
                "       0                         as pref_record_flag,\n" +
                "       null                      as name_prefix,\n" +
                "       null                      as first_name,\n" +
                "       null                      as middle_name,\n" +
                "       null                      as last_name,\n" +
                "       null                      as name_suffix,\n" +
                "       patient_name              as full_name,\n" +
                "       birth_date                as birth_datetime,\n" +
                "       null                      as ssn,\n" +
                "       sex_name                  as gender,\n" +
                "       null                      as birth_gender,\n" +
                "       null                      as race,\n" +
                "       language_name             as language,\n" +
                "       null                      as religion,\n" +
                "       nation_name               as ethnicity,\n" +
                "       null                      as military_status,\n" +
                "       null                      as activity_status_code,\n" +
                "       null                      as activity_status,\n" +
                "       e_mail                    as email_address,\n" +
                "       null                      as home_phone,\n" +
                "       phone_no                  as cell_phone,\n" +
                "       work_unit_phone           as work_phone,\n" +
                "       address                   as home_address,\n" +
                "       null                      as home_address_addtl,\n" +
                "       address_city              as home_city,\n" +
                "       address_province          as home_state,\n" +
                "       post_code                 as home_zip,\n" +
                "       '中国'                      as home_country\n" +
                "from case_base_info\n" +
                "where\n" +
                "  org_code = '11'\n" +
                "  and patient_id != ''\n" +
                "  and patient_id is not null\n" +
                "  and patient_id != 'null'\n" +
                "  and storage_datetime between '2020-07-12 00:00:00.000000000' and '2020-07-13 00:00:00.000000000'\n" +
                "  and patient_id not in\n" +
                "      (\n" +
                "        select t1.patient_id\n" +
                "        from (select pbi.patient_id as patient_id\n" +
                "              from patient_basic_info pbi\n" +
                "              where pbi.org_code = '11'\n" +
                "              union all\n" +
                "              select cbi.patient_id as patient_id\n" +
                "              from case_base_info cbi\n" +
                "              where cbi.org_code = '11'\n" +
                "            ) t1\n" +
                "        group by t1.patient_id\n" +
                "        having count(t1.patient_id) > 1\n" +
                "      )\n" +
                "order by patient_id desc\n" +
                "limit 10 offset 0;";
        List<String> list = parseSqlToFields(sql);
        System.out.println(list);
    }
}
