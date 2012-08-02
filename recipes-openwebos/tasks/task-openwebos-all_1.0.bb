DESCRIPTION = "All recipes in meta-webos layers - usefull only for devs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit task

PACKAGE_ARCH = "${MACHINE_ARCH}"

PR = "r0"

RDEPENDS_${PN} = " \
  enyo \
  luna-webkit-api \
  luna-sysmgr-ipc \
  luna-sysmgr-ipc-messages \
  nodejs-openwebos \
  task-openwebos-systemd \
  powerd \
  cjson-openwebos \
  sleepd \
  pmloglib \
  storaged \
  luna-service2 \
  nyx-lib \
  nyx-common-linux-modules \
  pbnjson \
  npapi-headers \
  yajl \
"
