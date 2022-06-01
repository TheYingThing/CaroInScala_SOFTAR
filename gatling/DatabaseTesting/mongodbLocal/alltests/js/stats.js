var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "8948",
        "ok": "4396",
        "ko": "4552"
    },
    "minResponseTime": {
        "total": "75",
        "ok": "75",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60019",
        "ok": "59979",
        "ko": "60019"
    },
    "meanResponseTime": {
        "total": "19562",
        "ok": "9519",
        "ko": "29261"
    },
    "standardDeviation": {
        "total": "21574",
        "ok": "11938",
        "ko": "24204"
    },
    "percentiles1": {
        "total": "10001",
        "ok": "3945",
        "ko": "10007"
    },
    "percentiles2": {
        "total": "22128",
        "ok": "15965",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "60000",
        "ok": "33141",
        "ko": "60002"
    },
    "percentiles4": {
        "total": "60006",
        "ok": "58062",
        "ko": "60009"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 469,
    "percentage": 5
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 470,
    "percentage": 5
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 3457,
    "percentage": 39
},
    "group4": {
    "name": "failed",
    "count": 4552,
    "percentage": 51
},
    "meanNumberOfRequestsPerSecond": {
        "total": "16.947",
        "ok": "8.326",
        "ko": "8.621"
    }
},
contents: {
"req_load-ec4d1": {
        type: "REQUEST",
        name: "load",
path: "load",
pathFormatted: "req_load-ec4d1",
stats: {
    "name": "load",
    "numberOfRequests": {
        "total": "4474",
        "ok": "1596",
        "ko": "2878"
    },
    "minResponseTime": {
        "total": "197",
        "ok": "197",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60019",
        "ok": "59585",
        "ko": "60019"
    },
    "meanResponseTime": {
        "total": "29525",
        "ok": "11019",
        "ko": "39788"
    },
    "standardDeviation": {
        "total": "24988",
        "ok": "11810",
        "ko": "24455"
    },
    "percentiles1": {
        "total": "12785",
        "ok": "5325",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "60000",
        "ok": "17005",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "60002",
        "ok": "33523",
        "ko": "60005"
    },
    "percentiles4": {
        "total": "60009",
        "ok": "57961",
        "ko": "60010"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 67,
    "percentage": 1
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 22,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1507,
    "percentage": 34
},
    "group4": {
    "name": "failed",
    "count": 2878,
    "percentage": 64
},
    "meanNumberOfRequestsPerSecond": {
        "total": "8.473",
        "ok": "3.023",
        "ko": "5.451"
    }
}
    },"req_save-43781": {
        type: "REQUEST",
        name: "save",
path: "save",
pathFormatted: "req_save-43781",
stats: {
    "name": "save",
    "numberOfRequests": {
        "total": "4474",
        "ok": "2800",
        "ko": "1674"
    },
    "minResponseTime": {
        "total": "75",
        "ok": "75",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60001",
        "ok": "59979",
        "ko": "60001"
    },
    "meanResponseTime": {
        "total": "9599",
        "ok": "8663",
        "ko": "11163"
    },
    "standardDeviation": {
        "total": "10391",
        "ok": "11926",
        "ko": "6839"
    },
    "percentiles1": {
        "total": "10000",
        "ok": "1906",
        "ko": "10001"
    },
    "percentiles2": {
        "total": "10006",
        "ok": "15813",
        "ko": "10002"
    },
    "percentiles3": {
        "total": "28877",
        "ok": "31871",
        "ko": "14485"
    },
    "percentiles4": {
        "total": "59102",
        "ok": "58063",
        "ko": "60000"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 402,
    "percentage": 9
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 448,
    "percentage": 10
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1950,
    "percentage": 44
},
    "group4": {
    "name": "failed",
    "count": 1674,
    "percentage": 37
},
    "meanNumberOfRequestsPerSecond": {
        "total": "8.473",
        "ok": "5.303",
        "ko": "3.17"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
