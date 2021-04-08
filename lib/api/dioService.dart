import 'package:dio/dio.dart';
import 'package:jee_api/api/model/Patient.dart';

class DioService {
  Dio _dio;

  void setOptions() {
    _dio = Dio(BaseOptions());
  }

  Future<List<Patient>> getPatients() async {
    try {
      this.setOptions();
      var response = await _dio.get("http://10.0.2.2:8080/patients");
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
