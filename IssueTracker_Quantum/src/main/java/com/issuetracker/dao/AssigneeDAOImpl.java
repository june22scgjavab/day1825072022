package com.issuetracker.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.issuetracker.model.Assignee;
import com.issuetracker.model.Unit;

public class AssigneeDAOImpl implements AssigneeDAO
{
    private List<Assignee> assigneeList = null;

    public AssigneeDAOImpl()
    {
//	Assignee assigneeOne = new Assignee("MTI-A-ADM-001", "Carry Luke",
//					    "carry.luke", Unit.ADMINISTRATION,
//					    LocalDate.now().minusWeeks(300), 3);
//
//	Assignee assigneeTwo = new Assignee("MTI-A-ADM-002", "Rodrick Luther",
//					    "rodrick_luther",
//					    Unit.ADMINISTRATION,
//					    LocalDate.now().minusWeeks(259), 3);
//
//	Assignee assigneeThree = new Assignee("MTI-A-CSG-001", "Miki Worth",
//					      "miki.w", Unit.CONSIGNMENT,
//					      LocalDate.now().minusWeeks(200),
//					      1);
//
//	Assignee assigneeFour = new Assignee("MTI-A-CSG-002", "Carlena Fife",
//					     "c_fife", Unit.CONSIGNMENT,
//					     LocalDate.now().minusWeeks(167),
//					     0);
//
//	Assignee assigneeFive = new Assignee("MTI-A-CSG-003", "Cedrick Padgett",
//					     "c.padgett", Unit.CONSIGNMENT,
//					     LocalDate.now().minusWeeks(243),
//					     0);
//
//	Assignee assigneeSix = new Assignee("MTI-A-CSG-004", "Tyrell Eaves",
//					    "tyrell_e", Unit.CONSIGNMENT,
//					    LocalDate.now().minusWeeks(300), 0);
//
//	Assignee assigneeSeven = new Assignee("MTI-A-CSG-005", "Jewel Seaton",
//					      "jewel_seaton", Unit.CONSIGNMENT,
//					      LocalDate.now().minusWeeks(259),
//					      0);
//
//	Assignee assigneeEight = new Assignee("MTI-A-PAY-001", "Larita Conklin",
//					      "larita.conklin", Unit.PAYMENT,
//					      LocalDate.now().minusWeeks(200),
//					      1);
//
//	Assignee assigneeNine = new Assignee("MTI-A-PAY-002", "Elyse Chu",
//					     "elyse.chu", Unit.PAYMENT,
//					     LocalDate.now().minusWeeks(167),
//					     1);
//
//	Assignee assigneeTen = new Assignee("MTI-A-SHP-001", "Elane Lester",
//					    "elane_lester", Unit.SHIPMENT,
//					    LocalDate.now().minusWeeks(243), 1);
//
//	Assignee assigneeEleven = new Assignee("MTI-A-SHP-002",
//					       "Valery Champion", "valery_c",
//					       Unit.SHIPMENT,
//					       LocalDate.now().minusWeeks(300),
//					       0);
//
//	Assignee assigneeTwelve = new Assignee("MTI-A-SHP-003", "Aaron Godfrey",
//					       "aaron.g", Unit.SHIPMENT,
//					       LocalDate.now().minusWeeks(259),
//					       0);
//
//	Assignee assigneeThirteen = new Assignee("MTI-A-SHP-004", "Jarvis Ivy",
//						 "jarvis_ivy", Unit.SHIPMENT,
//						 LocalDate.now()
//							  .minusWeeks(200),
//						 0);
//
//	Assignee assigneeFourteen = new Assignee("MTI-A-SHP-005",
//						 "Zackary Marble", "zackary.m",
//						 Unit.SHIPMENT,
//						 LocalDate.now()
//							  .minusWeeks(167),
//						 0);
//
//	Assignee assigneeFifteen = new Assignee("MTI-A-SHP-006",
//						"Williams Weir",
//						"williams_weir", Unit.SHIPMENT,
//						LocalDate.now().minusWeeks(243),
//						0);

//	assigneeList = List.of(assigneeOne, assigneeTwo, assigneeThree,
//			       assigneeFour, assigneeFive, assigneeSix,
//			       assigneeSeven, assigneeEight, assigneeNine,
//			       assigneeTen, assigneeEleven, assigneeTwelve,
//			       assigneeThirteen, assigneeFourteen,
//			       assigneeFifteen);
    }

    /**
     * @params
     *         unit - The assignee unit
     * 
     * @operation Fetches the assignees list for the given unit
     * 
     * @returns
     *          List<Assignee> - List of assignees fetched
     */
    @Override
    public List<Assignee> fetchAssignees(Unit unit)
    {
	Map<Unit, String> issueTypeCodeMap = new EnumMap<>(Unit.class);
	issueTypeCodeMap.put(Unit.ADMINISTRATION, "ADM");
	issueTypeCodeMap.put(Unit.CONSIGNMENT, "CSG");
	issueTypeCodeMap.put(Unit.PAYMENT, "PAY");
	issueTypeCodeMap.put(Unit.SHIPMENT, "SHP");

	String issueCode = issueTypeCodeMap.get(unit);

//	return assigneeList.stream()
//			   .filter(assignee -> issueCode.equals(assignee.getAssigneeId()
//									.split("-")[2]))
//			   .collect(Collectors.toList());
	return null;
    }

    /**
     * @params
     *         assigneeEmail - The assignee email id
     * 
     * @operation Fetches the assignee by the given email of the assignee
     * 
     * @returns
     *          Assignee - The fetched assignee object
     */
    @Override
    public Assignee getAssigneeByEmail(String assigneeEmail)
    {
//	return assigneeList.parallelStream()
//			   .filter(assignee -> assigneeEmail.equals(assignee.getAssigneeEmail()))
//			   .findFirst()
//			   .orElse(null);
	return null;
    }
}