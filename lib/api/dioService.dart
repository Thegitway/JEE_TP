import 'dart:convert';

import 'package:dio/dio.dart';
import 'package:jee_api/api/model/Patient.dart';
import 'package:http/http.dart' as http;

class DioService {
  Dio _dio;

  void setOptions() {
    _dio = Dio(BaseOptions(
      connectTimeout: 10000,
      receiveTimeout: 10000,
    ));
  }

  Future<List<Patient>> getPatients() async {
    /* try {
      var response = await http.get("http://localhost:8080/patient");
      List<Patient> patient = <Patient>[];
      print('before');

      if (response.statusCode == 200) {
        print('after');
        patient.add(Patient.fromJson(jsonDecode(response.body)));
      }
    } catch (e) {
      print(e);
    }
  }*/

    try {
      this.setOptions();
      print("before");
      var response = await _dio.get("http://localhost:8080/patient");
      print("after request");
      print(response.statusCode.toString());
      if (response.statusCode == 200) {
        List<Patient> patient = <Patient>[];
        for (Map<String, dynamic> toto in response.data)
          patient.add(Patient.fromJson(toto));
        return patient;
      }
      return <Patient>[];
    } catch (e) {
      print(e);
    }
  }
}
