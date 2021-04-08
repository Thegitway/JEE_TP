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
            body: Padding(
              padding: const EdgeInsets.all(15.0),
              child: Table(
                border: TableBorder.all(width: 1),
                children: [
                  for (Patient pp in p)
                    TableRow(
                      children: [
                        Center(child: Text(pp.nom)),
                        Center(child: Text(pp.score.toString()))
                      ],
                    ),
                ],
              ),
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
