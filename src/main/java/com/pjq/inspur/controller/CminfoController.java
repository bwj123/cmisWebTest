package com.pjq.inspur.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pjq.common.util.DateUtils;
import com.pjq.common.util.GeneratorIDUntils;
import com.pjq.inspur.pojo.GzcrmCminfo;
import com.pjq.inspur.service.CminfoService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cminfo")
public class CminfoController {
    @Autowired
    private CminfoService cminfoService;

    @RequestMapping("/beforeLook")
    public String beforeLook(int cmId, Model model) {
        GzcrmCminfo cminfo = cminfoService.queryCminfoById(cmId);
        model.addAttribute("cminfo", cminfo);
        return "manager/clientMgrInfoDetail";
    }

    @RequestMapping("/insertCminfo")
    public String insertCminfo(GzcrmCminfo gzcrmCminfo,
                               MultipartFile picture,
                               Model model,
                               HttpSession session) {
        gzcrmCminfo.setCmStatus("T");
        // 保存图片的路径，图片上传成功后，将路径保存到数据库
        String filePath = "F:\\A课程\\7.银行管理系统\\ljhProject\\cmsproject01\\src\\main\\webapp\\upload\\cminfoPic";
        // 获取原始图片的扩展名
        String originalFilename = picture.getOriginalFilename();
        // 生成文件新的名字
        String newFileName = GeneratorIDUntils.getDateTime() + "." + originalFilename.split("\\.")[1];
        // 封装上传文件位置的全路径
        File targetFile = new File(filePath, newFileName);
        try {
            picture.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 保存路径到gzcrmCminfo
        gzcrmCminfo.setCmPhoto(newFileName);
        gzcrmCminfo.setCmModificationPerson((String) session.getAttribute("uname"));
        int nums = cminfoService.insertCminfo(gzcrmCminfo);
        if (nums == 1) {
            System.out.println("添加客户经理成功！");
            model.addAttribute("msg", "<script>alert('添加客户经理成功！');</script>");
        } else {
            System.out.println("添加客户经理失败！！");
            model.addAttribute("msg", "<script>alert('添加客户经理失败！');</script>");
        }
        return "redirect:/cminfo/queryCminfoList";
    }

    @RequestMapping("/queryCminfoList")
    public String qeuryCminfoList(@RequestParam(required = false) String deptName,
                                  @RequestParam(required = false) String cminfoId,
                                  @RequestParam(required = false) String status,
                                  @RequestParam(required = false) String cmName,
                                  @RequestParam(required = false) String msg,
                                  @RequestParam(defaultValue = "1") int pageNum,
                                  Model model) {
        PageHelper.startPage(pageNum, 5);
        List<GzcrmCminfo> list = cminfoService.queryCminfoList(deptName, cminfoId, cmName, status);
        PageInfo<GzcrmCminfo> info = new PageInfo<>(list);
        model.addAttribute("deptName", deptName);
        model.addAttribute("cminfoId", cminfoId);
        model.addAttribute("status", status);
        model.addAttribute("msg", msg);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("cmName", cmName);
        model.addAttribute("info", info);
        return "manager/clientMgr";
    }

    @RequestMapping("/deleteCminfo")
    public String deleteCminfo(int cmId, Model model) {
        int nums = cminfoService.deleteCminfoById(cmId);
        if (nums == 1) {
            System.out.println("删除客户经理成功！");
            model.addAttribute("msg", "<script>alert('删除客户经理成功！');</script>");
        } else {
            System.out.println("删除客户经理失败！！");
            model.addAttribute("msg", "<script>alert('删除客户经理失败！');</script>");
        }
        return "redirect:/cminfo/queryCminfoList";
    }

    @RequestMapping("/beforeUpdate")
    public String beforeUpdate(int cmId, Model model) {
        GzcrmCminfo cminfo = cminfoService.queryCminfoById(cmId);
        model.addAttribute("cminfo", cminfo);
        return "manager/clientMgrUpdate";
    }

    @RequestMapping("/updateCminfo")
    public String updateCminfo(GzcrmCminfo gzcrmCminfo, Model model, MultipartFile picture) {
        if (!picture.isEmpty() && picture != null) {
            // 保存图片的路径，图片上传成功后，将路径保存到数据库
            String filePath = "F:\\A课程\\7.银行管理系统\\ljhProject\\cmsproject01\\src\\main\\webapp\\upload\\cminfoPic";
            // 获取原始图片的扩展名
            String originalFilename = picture.getOriginalFilename();
            // 生成文件新的名字
            String newFileName = GeneratorIDUntils.getDateTime() + "." + originalFilename.split("\\.")[1];
            // 封装上传文件位置的全路径
            File targetFile = new File(filePath, newFileName);
            try {
                picture.transferTo(targetFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 保存路径到gzcrmCminfo
            gzcrmCminfo.setCmPhoto(newFileName);
        }
        int nums = cminfoService.updateCminfo(gzcrmCminfo);
        if (nums == 1) {
            System.out.println("更新客户经理信息成功！");
            model.addAttribute("msg", "<script>alert('更新客户经理信息成功！');</script>");
        } else {
            System.out.println("更新客户经理信息失败！！");
            model.addAttribute("msg", "<script>alert('更新客户经理信息失败！');</script>");
        }
        return "redirect:/cminfo/queryCminfoList";
    }

    @RequestMapping("/deleteMany")
    public String deleteMany(String checkTnum, Model model) {
        boolean flag = cminfoService.deleteMany(checkTnum);
        if (flag) {
            System.out.println("批量删除客户经理成功！");
            model.addAttribute("msg", "<script>alert('批量删除客户经理成功');</script>");
        } else {
            System.out.println("批量删除客户经理失败！");
            model.addAttribute("msg", "<script>alert('批量删除客户经理失败');</script>");
        }
        return "redirect:/cminfo/queryCminfoList";
    }

    @RequestMapping("/importCminfo")
    public String improtCminfo(@RequestParam("exclefile") MultipartFile file,
                               Model model,
                               HttpSession session) {
        ArrayList<String> errors = new ArrayList<String>();
        try {
            if (!file.isEmpty() && file.getOriginalFilename().endsWith("xlsx")) {
                // poi--exl解析
                InputStream is = file.getInputStream();
                //HSSFWorkbook hssf = new HSSFWorkbook(is);
                XSSFWorkbook xssf = new XSSFWorkbook(is);
                //Sheet1-----是Excel表格左下方的名称
                Sheet sheet = xssf.getSheet("Sheet1");
                //读取Excel表格从下标0开始（表头开始）
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    //开始导入
                    GzcrmCminfo gzcrmCminfo = new GzcrmCminfo();
                    gzcrmCminfo.setCmId(Integer.parseInt(sheet.getRow(i).getCell(0).toString()));
                    gzcrmCminfo.setCmName(sheet.getRow(i).getCell(1).toString());
                    gzcrmCminfo.setCmSex(sheet.getRow(i).getCell(2).toString());
                    gzcrmCminfo.setCmSsn(sheet.getRow(i).getCell(3).toString());
                    gzcrmCminfo.setCmBirthday(DateUtils.parse(sheet.getRow(i).getCell(4).toString()));
                    gzcrmCminfo.setCmAge(Integer.parseInt(sheet.getRow(i).getCell(5).toString()));
                    gzcrmCminfo.setCmNation(sheet.getRow(i).getCell(6).toString());
                    gzcrmCminfo.setCmPoliticalLandscape(sheet.getRow(i).getCell(7).toString());
                    gzcrmCminfo.setCmHometown(sheet.getRow(i).getCell(8).toString());
                    gzcrmCminfo.setCmEducation(sheet.getRow(i).getCell(9).toString());
                    gzcrmCminfo.setCmDegree(sheet.getRow(i).getCell(10).toString());
                   // gzcrmCminfo.setCmStatus(sheet.getRow(i).getCell(11).toString());
                    gzcrmCminfo.setCmGraduated(sheet.getRow(i).getCell(11).toString());
                    gzcrmCminfo.setCmProfessionalTitles(sheet.getRow(i).getCell(12).toString());
                    gzcrmCminfo.setCmLevel(sheet.getRow(i).getCell(13).toString());
                    gzcrmCminfo.setCmUnit(sheet.getRow(i).getCell(14).toString());
                    gzcrmCminfo.setCmDept(sheet.getRow(i).getCell(15).toString());
                    gzcrmCminfo.setCmPosition(sheet.getRow(i).getCell(16).toString());
                    gzcrmCminfo.setCmBusinessLines(sheet.getRow(i).getCell(17).toString());
                    gzcrmCminfo.setCmHiredate(DateUtils.parse(sheet.getRow(i).getCell(18).toString()));
                    gzcrmCminfo.setCmEntryTime(DateUtils.parse(sheet.getRow(i).getCell(19).toString()));
                    gzcrmCminfo.setCmFinancialYears(Integer.parseInt(sheet.getRow(i).getCell(20).toString()));
                    gzcrmCminfo.setCmWorkingYears(Integer.parseInt(sheet.getRow(i).getCell(21).toString()));
                   // gzcrmCminfo.setCmResultsLastYear(Integer.parseInt(sheet.getRow(i).getCell(18).toString()));
                    //gzcrmCminfo.setCmTotalCredits(Integer.parseInt(sheet.getRow(i).getCell(19).toString()));
                   gzcrmCminfo.setCmTel(sheet.getRow(i).getCell(22).toString());
                    gzcrmCminfo.setCmMobile(sheet.getRow(i).getCell(23).toString());
                   // gzcrmCminfo.setCmCertificateNumber(sheet.getRow(i).getCell(27).toString());
                    //gzcrmCminfo.setCmQualificationDate(DateUtils.parse(sheet.getRow(i).getCell(28).toString()));
                    //gzcrmCminfo.setCmQualificationPeriod(Integer.parseInt(sheet.getRow(i).getCell(29).toString()));
                    //gzcrmCminfo.setCmStatusNumber(sheet.getRow(i).getCell(30).toString());
                    //gzcrmCminfo.setCmStatusNumberDate(DateUtils.parse(sheet.getRow(i).getCell(31).toString()));
                    //gzcrmCminfo.setCmStatusNumberPeriod(Integer.parseInt(sheet.getRow(i).getCell(32).toString()));
                    //gzcrmCminfo.setCmLevelNumber(sheet.getRow(i).getCell(33).toString());
                    //gzcrmCminfo.setCmLevelDate(DateUtils.parse(sheet.getRow(i).getCell(34).toString()));
                    //gzcrmCminfo.setCmLevelPeriod(Integer.parseInt(sheet.getRow(i).getCell(35).toString()));
                    gzcrmCminfo.setCmModificationDate(DateUtils.parse(sheet.getRow(i).getCell(24).toString()));
                    //gzcrmCminfo.setCmModificationPerson((String) session.getAttribute("uname"));
                    cminfoService.insertCminfo(gzcrmCminfo);
                }
                is.close();
            } else {
                model.addAttribute("msg", "<script>alert('上传文件不符合格式！');</script>！");
                return "manager/clientMgrImport";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("msg", "<script>alert('导入成功！');</script>！");
        return "redirect:/cminfo/queryCminfoList";
    }

    @RequestMapping("/exportExcle")
    public void exportEccle(@RequestParam(required = false) String deptName,
                            @RequestParam(required = false) String cminfoId,
                            @RequestParam(required = false) String status,
                            @RequestParam(required = false) String cmName,
                            HttpSession session,
                            HttpServletResponse response,
                            Model model) {
        String name = (String) session.getAttribute("uname");
        List<GzcrmCminfo> list = cminfoService.queryCminfoList(deptName, cminfoId, cmName, status);
        response.setCharacterEncoding("UTF-8");
        //生成excel
        XSSFWorkbook xssf = new XSSFWorkbook();
        Sheet sheet = xssf.createSheet();
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("客户经理编号");
        row.createCell(1).setCellValue("姓名");
        row.createCell(2).setCellValue("性别");
        row.createCell(3).setCellValue("身份证号");
        row.createCell(4).setCellValue("出生日期");
        row.createCell(5).setCellValue("客户经理等级");
        row.createCell(6).setCellValue("机构");
        row.createCell(7).setCellValue("部门");
        //记录行数
        int index = 1;
        for (int i = 0; i < list.size(); i++) {
            GzcrmCminfo tmp = list.get(i);
            Row tmpRow = sheet.createRow(i + 1);
            tmpRow.createCell(0).setCellValue(tmp.getCmId());
            tmpRow.createCell(1).setCellValue(tmp.getCmName());
            tmpRow.createCell(2).setCellValue(tmp.getCmSex());
            tmpRow.createCell(3).setCellValue(tmp.getCmSsn());
            tmpRow.createCell(4).setCellValue(DateUtils.format(tmp.getCmBirthday()));
            tmpRow.createCell(5).setCellValue(tmp.getCmLevel());
            tmpRow.createCell(6).setCellValue(tmp.getCmUnit());
            tmpRow.createCell(7).setCellValue(tmp.getCmDept());
        }
        System.out.println("生成成功!");
        try {
            String date = "_" + DateUtils.getSysDate().replaceAll("-", "");
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="
                    + new String("客户经理名单_".getBytes(), "iso-8859-1") + name + ".xlsx");
            OutputStream ouputStream = response.getOutputStream();
            xssf.write(ouputStream);
            ouputStream.flush();
            ouputStream.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/queryCminfoStatList")
    public String queryCminfoStatList(@RequestParam(required = false) String cmUnit,
                                      @RequestParam(required = false) String cmStatus,
                                      @RequestParam(required = false) String cmSex,
                                      @RequestParam(required = false) String cmEdu,
                                      @RequestParam(required = false) String cmPL,
                                      @RequestParam(required = false) String cmLevel,
                                      Model model) {
        List<GzcrmCminfo> list = cminfoService.queryDetil(cmUnit, cmStatus, cmSex, cmEdu, cmPL, cmLevel);
        model.addAttribute("cmUnit", cmUnit);
        model.addAttribute("cmStatus", cmStatus);
        model.addAttribute("cmSex", cmSex);
        model.addAttribute("cmEdu", cmEdu);
        model.addAttribute("cmPL", cmPL);
        model.addAttribute("cmLevel", cmLevel);
        model.addAttribute("list", list);
        return "manager/clientMgrStat";
    }

    @RequestMapping("/exportMgrStat")
    public void exportMgrStat(@RequestParam(required = false) String cmUnit,
                              @RequestParam(required = false) String cmStatus,
                              @RequestParam(required = false) String cmSex,
                              @RequestParam(required = false) String cmEdu,
                              @RequestParam(required = false) String cmPL,
                              @RequestParam(required = false) String cmLevel,
                              HttpSession session,
                              HttpServletResponse response,
                              Model model) {
        List<GzcrmCminfo> list = cminfoService.queryDetil(cmUnit, cmStatus, cmSex, cmEdu, cmPL, cmLevel);
        String name = (String) session.getAttribute("uname");
        response.setCharacterEncoding("UTF-8");
        //生成excel
        XSSFWorkbook xssf = new XSSFWorkbook();
        Sheet sheet = xssf.createSheet();
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("客户经理编号");
        row.createCell(1).setCellValue("姓名");
        row.createCell(2).setCellValue("性别");
        row.createCell(3).setCellValue("客户经理等级");
        row.createCell(4).setCellValue("机构");
        row.createCell(5).setCellValue("部门");
        row.createCell(6).setCellValue("业务条线");
        row.createCell(7).setCellValue("职务");
        row.createCell(8).setCellValue("客户经理从业年限");
        row.createCell(9).setCellValue("联系电话");
        row.createCell(10).setCellValue("在职状态");
        row.createCell(11).setCellValue("年龄");
        row.createCell(12).setCellValue("学历");
        row.createCell(13).setCellValue("专业职称");
        //记录行数
        int index = 1;
        for (int i = 0; i < list.size(); i++) {
            GzcrmCminfo tmp = list.get(i);
            Row tmpRow = sheet.createRow(i + 1);
            tmpRow.createCell(0).setCellValue(tmp.getCmId());
            tmpRow.createCell(1).setCellValue(tmp.getCmName());
            tmpRow.createCell(2).setCellValue(tmp.getCmSex());
            tmpRow.createCell(3).setCellValue(tmp.getCmLevel());
            tmpRow.createCell(4).setCellValue(tmp.getCmUnit());
            tmpRow.createCell(5).setCellValue(tmp.getCmDept());
            tmpRow.createCell(6).setCellValue(tmp.getCmBusinessLines());
            tmpRow.createCell(7).setCellValue(tmp.getCmPosition());
            tmpRow.createCell(8).setCellValue(tmp.getCmWorkingYears());
            tmpRow.createCell(9).setCellValue(tmp.getCmMobile());
            tmpRow.createCell(10).setCellValue(tmp.getCmStatus());
            tmpRow.createCell(11).setCellValue(tmp.getCmAge());
            tmpRow.createCell(12).setCellValue(tmp.getCmEducation());
            tmpRow.createCell(13).setCellValue(tmp.getCmProfessionalTitles());
        }
        System.out.println("生成成功!");
        try {
            String date = "_" + DateUtils.getSysDate().replaceAll("-", "");
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="
                    + new String("客户经理报表_".getBytes(), "iso-8859-1") + name + ".xlsx");
            OutputStream ouputStream = response.getOutputStream();
            xssf.write(ouputStream);
            ouputStream.flush();
            ouputStream.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}