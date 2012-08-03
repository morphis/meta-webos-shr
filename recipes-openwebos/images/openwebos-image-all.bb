require openwebos-image.bb

# usefull only for devs and automated builds to force do_rootfs for all packages we have in feed

RDEPENDS_${PN} += " \
  task-openwebos-all \
"

IMAGE_INSTALL += " \
  task-openwebos-all \
"
