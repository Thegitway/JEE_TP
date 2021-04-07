import "package:flutter/material.dart";
import "package:jee_api/api/dioService.dart";

import 'package:jee_api/api/model/Patient.dart';

class Index extends StatefulWidget {
  Index();
  @override
  _IndexPageState createState() => _IndexPageState();
}

class _IndexPageState extends State<Index> {
  DioService dioService;
  Size srcSize;
  @override
  void initState() {
    super.initState();
    dioService = DioService();
  }

  @override
  void dispose() {
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    srcSize = MediaQuery.of(context).size;
    return FutureBuilder(
      future: dioService.getPatients(),
      builder: (context, snapshot) {
        if (snapshot.hasData) {
          List<Patient> p = snapshot.data;
          return Scaffold(
            appBar: AppBar(
              title: Text("JEE"),
            ),
            body: Table(
              children: [
                TableRow(
                  children: [Text(p.first.nom), Text(p.first.score.toString())],
                ),
              ],
            ),
          );
        } else {
          return Center(
              child: Container(
                  height: srcSize.height * 0.25,
                  width: srcSize.height * 0.25,
                  child: CircularProgressIndicator()));
        }
      },
    );
  }
}
