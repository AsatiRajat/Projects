package com.yash.practice.solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee employee1 = new Employee("Yash", 23, new Address("1234"),
				Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

		Employee employee2 = new Employee("Ram", 24, new Address("1235"),
				Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

		Employee employee3 = new Employee("Sita", 21, new Address("1236"),
				Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

		List<Employee> employees = Arrays.asList(employee1, employee2, employee3);

		// Get employee with exact match name "Yash", if not found print "Not
		// found".
		Optional<Employee> empNameMatch = employees.stream().filter(e -> "Yash".equals(e.getName())).findAny();
		if (empNameMatch.isPresent()) {
			System.out.println("Emplyoee found.");
		} else {
			System.out.println("Not found.");
		}

		// Get employee with matching address "1235"
		Optional<Employee> addressMatch = employees.stream().filter(e -> "1235".equals(e.getAddress().getZipcode()))
				.findAny();
		if (addressMatch.isPresent()) {
			System.out.println("\n" + addressMatch.get());
		} else {
			System.out.println("\n" + addressMatch);
		}

		// Get all employee having mobile numbers 3333.
		String mobileNumber = "3333";
		List<Employee> empList = employees.stream()
				.filter(e -> e.getMobileNumbers().stream().anyMatch(m -> m.getNumber().equals(mobileNumber)))
				.collect(Collectors.toList());
		System.out.println("\nEmployees having mobile number " + mobileNumber + " : " + empList);

		// Convert List<Employee> to List<String> of employee name
		List<String> empNamelist = employees.stream().map(e -> e.getName().toString()).collect(Collectors.toList());
		System.out.println("\nEmployee name list : " + empNamelist);

		// Collect all the names of employees in a string separated by ||
		// String separatedString = employees.stream().map(e ->
		// e.getName().toString()).collect(Collectors.joining(" || "));
		String separatedString = empNamelist.stream().collect(Collectors.joining(" || "));
		System.out.println("\nString separated by '||' --> : " + separatedString);

		// Change the case of List<String>
		List<String> caseChangeEmpList = empNamelist.stream().map(e -> e.toUpperCase()).collect(Collectors.toList());
		System.out.println("\nCase Change Employee list : " + caseChangeEmpList);

		// Sort List<String>
		List<String> sortedList = empNamelist.stream().sorted().collect(Collectors.toList());
		System.out.println("\nSorted Employee list : " + sortedList);

		// sort List<Employee> based on name
		List<Employee> sortedListByName = employees.stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
				.collect(Collectors.toList());
		System.out.println("\nSorted Employee list based on name : " + sortedListByName);

		// sort List<Employee> based on age
		List<Employee> sortedListByAge = employees.stream().sorted(Comparator.comparing(Employee::getAge))
				.collect(Collectors.toList());
		System.out.println("\nSorted Employee list based on age : " + sortedListByAge);

		// sort List<Employee> based on address
		List<Employee> sortedListByAddress = employees.stream()
				.sorted((e1, e2) -> e1.getAddress().getZipcode().compareTo(e2.getAddress().getZipcode()))
				.collect(Collectors.toList());
		System.out.println("\nSorted Employee list based on address : " + sortedListByAddress);

	}

}
