var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "2020",
        "ok": "1186",
        "ko": "834"
    },
    "minResponseTime": {
        "total": "73",
        "ok": "73",
        "ko": "8453"
    },
    "maxResponseTime": {
        "total": "60002",
        "ok": "55406",
        "ko": "60002"
    },
    "meanResponseTime": {
        "total": "23571",
        "ok": "9869",
        "ko": "43057"
    },
    "standardDeviation": {
        "total": "23889",
        "ok": "11480",
        "ko": "23412"
    },
    "percentiles1": {
        "total": "10701",
        "ok": "6109",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "60000",
        "ok": "13438",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "60000",
        "ok": "34835",
        "ko": "60001"
    },
    "percentiles4": {
        "total": "60001",
        "ok": "45222",
        "ko": "60001"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 203,
    "percentage": 10
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 134,
    "percentage": 7
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 849,
    "percentage": 42
},
    "group4": {
    "name": "failed",
    "count": 834,
    "percentage": 41
},
    "meanNumberOfRequestsPerSecond": {
        "total": "19.612",
        "ok": "11.515",
        "ko": "8.097"
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
        "total": "1010",
        "ok": "383",
        "ko": "627"
    },
    "minResponseTime": {
        "total": "531",
        "ok": "531",
        "ko": "10387"
    },
    "maxResponseTime": {
        "total": "60002",
        "ok": "55406",
        "ko": "60002"
    },
    "meanResponseTime": {
        "total": "40996",
        "ok": "19796",
        "ko": "53947"
    },
    "standardDeviation": {
        "total": "22500",
        "ok": "14137",
        "ko": "15847"
    },
    "percentiles1": {
        "total": "60000",
        "ok": "16495",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "60000",
        "ok": "30778",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "60001",
        "ok": "44116",
        "ko": "60001"
    },
    "percentiles4": {
        "total": "60001",
        "ok": "55304",
        "ko": "60001"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 2,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 9,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 372,
    "percentage": 37
},
    "group4": {
    "name": "failed",
    "count": 627,
    "percentage": 62
},
    "meanNumberOfRequestsPerSecond": {
        "total": "9.806",
        "ok": "3.718",
        "ko": "6.087"
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
        "total": "1010",
        "ok": "803",
        "ko": "207"
    },
    "minResponseTime": {
        "total": "73",
        "ok": "73",
        "ko": "8453"
    },
    "maxResponseTime": {
        "total": "20411",
        "ok": "20411",
        "ko": "14791"
    },
    "meanResponseTime": {
        "total": "6146",
        "ok": "5134",
        "ko": "10071"
    },
    "standardDeviation": {
        "total": "5276",
        "ok": "5467",
        "ko": "688"
    },
    "percentiles1": {
        "total": "5550",
        "ok": "1876",
        "ko": "10000"
    },
    "percentiles2": {
        "total": "10001",
        "ok": "9763",
        "ko": "10001"
    },
    "percentiles3": {
        "total": "14502",
        "ok": "14757",
        "ko": "10002"
    },
    "percentiles4": {
        "total": "20097",
        "ok": "20210",
        "ko": "14790"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 201,
    "percentage": 20
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 125,
    "percentage": 12
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 477,
    "percentage": 47
},
    "group4": {
    "name": "failed",
    "count": 207,
    "percentage": 20
},
    "meanNumberOfRequestsPerSecond": {
        "total": "9.806",
        "ok": "7.796",
        "ko": "2.01"
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
